# Host Pathogen Database Web Application on OpenShift

<p align="left">
  <img src="https://img.shields.io/badge/Platform-OpenShift-red?logo=red-hat-openshift" alt="OpenShift">
  <img src="https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql&logoColor=white" alt="MySQL">
</p>

Agriculture and Agri-Food Canada’s (AAFC) internally developed Host Pathogen Database (HPDB) Web Application has been created to give access to the AAFC curated Host-Pathogen Database. The application currently allows the searching of Host Records, Pathogen Records and Host-Pathogen Records.

This repository contains the Kubernetes/OpenShift manifests required to deploy the HPDB application and its associated MySQL database.

[Demo Site](https://hpdb-route-aafc-labs-can.apps.edcm-science-ocp-ops1.science.gc.ca/)

## Architecture Overview

- **Frontend:** PHP-based application (HPDB) served via OpenShift Route.
- **Backend:** MariaDB 10.5.29. 
  - *FORMERLY: MySQL 5.6*
- **Storage:** Persistent Volume Claim (PVC) for database data.
- **Build System:** Build using Dockerfile, push to Quay repo.

## Component Details

### 1. Database Layer (MySQL)
*   **Secret (`hpdb-mysql-credentials`):** Stores the database username, password, and database name.
*   **PVC (`hpdb-mysql-pvc`):** Requests 1Gi of persistent storage to ensure database data survives pod restarts.

*   **Deployment (`hpdb-db`):** Runs the `centos/mysql-56-centos7` image.
*   **Service (`hpdb-db`):** Internal load balancer that allows the app to communicate with the DB via the hostname `hpdb-db`.

### 2. Application Layer (HPDB)
*   **Deployment (`hpdb-app`):** Runs the HPDB container. It pulls database credentials from the Secret and connects to the database using environment variables.
*   **Service (`hpdb-app-service`):** Internal service mapping port 8080.
*   **Route (`hpdb-route`):** Provides a public URL to access the application from a web browser.

## Environment Variables
The application container uses the following environment variables:

| Variable | Source | Description |
|----------|--------|-------------|
| `MYSQL_USER` | Secret | Database username |
| `MYSQL_PASSWORD` | Secret | Database password |
| `MYSQL_DATABASE` | Secret | Target database name |
| `JAVA_TOOL_OPTIONS` | Static | Loggers for debugging |

# 🚀 Build & Deploy on OpenShift

The application is built using its `Dockerfile` via Docker or Podman, pushed to a container image repo such as Quay, 

## 1. Rebuild and push the image (if you changed source code/dockerfile)
```bash
# From anywhere on your local machine
sudo podman login <image-repo-name> --tls-verify=false

# From directory containing dockerfile on your local machine
sudo podman build -t <image-repo-name>:<tag> . 

sudo <image-repo-name>:<tag> --tls-verify=false
```
AAFC repo used: quay-quay-openshift-operators.apps.edcm-science-ocp-ops1.science.gc.ca/aafc-labs-can/hpdb:latest 

## 2. Move each .yml file to the GPSC 
Use [Rsync](https://001gc.sharepoint.com/sites/94783/SitePages/rsync.aspx) or another tool.

Example rsync command:
```bash
rsync -hlPrtvz --chmod=Dg+s </path/to/>hpdb/hpdb-oc-deploy.yml <username>@inter-aafc-ubuntu2404.science.gc.ca:<path/to/somewhere/in/the/GPSC>/hpdb/hpdb-oc-deploy.yml
# do the same with hpdb-secret.yml if you externalize the secret file
```

## 3. Apply Kubernetes objects
* If you haven't already, log in to OpenShift in your GPSC terminal.
* From directory in the GPSC where you moved your .yml files:
  ```bash
  oc apply -f hpdb-oc-deploy.yml

  # do the same with hpdb-secret.yml if you externalize the secret file
  ```
## 4. Restart deployments

If you already had HPDB deployed on your cluster and are updating it, you will need to restart the deployments.
* Scale them down to zero:
    ```bash
    oc scale deployment/hpdb-db --replicas=0

    oc scale deployment/hpdb-app --replicas=0
    ```
* Restart the deployments:

  ```bash
  oc rollout restart deployment/hpdb-app
  oc rollout restart deployment/hpdb-db
  ```
* Scale them back up:
    ```bash
    oc scale deployment/hpdb-db --replicas=1

    oc scale deployment/hpdb-app --replicas=1
    ```
* Give it fifteen or more seconds. The hpdb-app deployment takes awhile to kick in.
## 5. Upload database data:

```bash
# from the GPSC
oc exec -i -n <openshift-namespace> deployment/hpdb-db -- mysql -u hpdb_user -phpdbwebaafc1 hpdbweb < mysql-dump/hpdb.sql

# check if it worked
oc exec -n <openshift-namespace> deployment/hpdb-db -- \
  mysql -u hpdb_user -phpdbwebaafc1 hpdbweb \
  -e "SHOW TABLES;"
  # should show a bunch of tables like app_user, host, hostPathogen... user_role
```

# TROUBLESHOOTING

## Monitoring Application Logs

```bash
oc logs -f deployment/hpdb-app
```
## If "Application is not available", yet both pods are running
* Give it fifteen or more seconds. The hpdb-app deployment takes awhile to kick in.
* The hpdb-mysql-pvc may still be attached to an old database pod, preventing new one from attaching. This is likely to happen after a rollout restart. To fix:
  * Delete the old pod
  * Restart the database deployment using `oc rollout restart deployment/hpdb-db`

## To cleanly restart the database
* Login to SQL in the hpdb-db pod:
  ```bash
  mysql -u hpdb_user -phpdbwebaafc1 hpdbweb 
  ```

* Drop the database:
  ```bash
  # Within hpdb-db pod
  DROP DATABASE IF EXISTS hpdbweb;

  # if it's not dropping (ie process hangs):
    # -hit CTRL+C to exit
    # -check what other processes are using the database:
    SHOW PROCESSLIST;
    # -Then kill those other processes;
    KILL <number>; # ie KILL 12;
  ```

* Recreate the database.
  ```bash
  # Within hpdb-db pod
  CREATE DATABASE hpdbweb;
  ```

* From the HPDB directory in the GPSC, upload the sql file into the database:
  ```bash
  oc exec -i -n <openshift-namespace> deployment/hpdb-db -- mysql -u hpdb_user -phpdbwebaafc1 hpdbweb < mysql-dump/hpdb.sql
  ```

* Check if it worked:
  * In hpdb-db pod:
    ```bash
    # log out of mysql if logged in:
    exit

    # log in again
    mysql -u hpdb_user -phpdbwebaafc1 hpdbweb 

    # check if tables are there by listing all tables
    SHOW TABLES;

    # check if a table actually has data
    SELECT COUNT(*) FROM <table name>; # ie SELECT COUNT(*) FROM reference;
    ```

## Restoring the application to a version that "WORKED EARLIER"
* Revert on GitLab to a branch you KNOW worked earlier:
  * Create a backup copy of your project directory on your local machine, just in case!
  * Revert your branch on GitHub or GitLab to a commit you KNOW worked earlier.
  * Use `git pull` to pull the old commit to your local branch.
* ^A similar process should exist for GitHub.
* Rebuild and re-push the image to Quay.
* Use rsync or another tool to move the right .yml file back to the GPSC.
  * Use `cat <filename>` in the GPSC and inspect the file(s) to make sure you're using your updated file(s) and not old versions.
* Apply your updated .yml or .yaml file(s) with `oc apply -f <filename>`
* Use `oc rollout restart` on both deployments.
  * If they have a hard time restarting, scale them down to 0 and back up to 1:
    ```bash
    oc scale deployment/<deployment> --replicas=0

    oc scale deployment/<deployment> --replicas=1
    ```
