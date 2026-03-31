# HPDB OpenShift Deployment Guide
# HPDB OpenShift Deployment Guide

<p align="left">
  <img src="https://img.shields.io/badge/Platform-OpenShift-red?logo=red-hat-openshift" alt="OpenShift">
  <img src="https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql&logoColor=white" alt="MySQL">
</p>

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
The application container uses the following environment variables:

| Variable | Source | Description |
|----------|--------|-------------|
| `MYSQL_USER` | Secret | Database username |
| `MYSQL_PASSWORD` | Secret | Database password |
| `MYSQL_DATABASE` | Secret | Target database name |
| `JAVA_TOOL_OPTIONS` | Static | Loggers for debugging |

# 🚀 Build & Deploy

The application is built directly inside OpenShift using a Dockerfile defined in the BuildConfig.

## 1. Rebuild and push the image (if you changed source code/dockerfile)
```bash
# From anywhere on your local machine
sudo podman login quay-quay-openshift-operators.apps.edcm-science-ocp-ops1.science.gc.ca/aafc-labs-can/hpdb --tls-verify=false

# From directory containing dockerfile on your local machine
sudo podman build -t quay-quay-openshift-operators.apps.edcm-science-ocp-ops1.science.gc.ca/aafc-labs-can/hpdb:latest . 

sudo podman push quay-quay-openshift-operators.apps.edcm-science-ocp-ops1.science.gc.ca/aafc-labs-can/hpdb:latest --tls-verify=false
```

## 2. Move .yml file to the GPSC 
Use [Rsync](https://001gc.sharepoint.com/sites/94783/SitePages/rsync.aspx) or another tool.

Example rsync command:
```bash
rsync -hlPrtvz --chmod=Dg+s </path/to/>hpdb/hpdb-oc-deploy.yml <username>@inter-aafc-ubuntu2404.science.gc.ca:<path/to/somewhere/in/the/GPSC>/hpdb/hpdb-oc-deploy.yml
```

## 3. Apply Kubernetes objects
* If you haven't already, log in to OpenShift in your GPSC terminal.
* From directory in the GPSC where you moved the hpdb-oc-deploy.yml file:
  ```bash
  oc apply -f hpdb-oc-deploy.yml
  ```
## 4. Restart deployment

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
## 5. Upload database data:

```bash
# from the GPSC
oc exec -i -n aafc-labs-can-dev deployment/hpdb-db -- mysql -u hpdb_user -phpdbwebaafc1 hpdbweb   < mysql-dump/hpdb.sql

# check if it worked
oc exec -n aafc-labs-can-dev deployment/hpdb-db -- \
  mysql -u hpdb_user -phpdbwebaafc1 hpdbweb \
  -e "SHOW TABLES;"
  # should show a bunch of tables like app_user, host, hostPathogen... user_role
```

# EXECUTING DATABASE COMMANDS

### Logging in to the database within the pod:

```bash
# mysql -u username -p databasename
$ mysql -u hpdb_user -phpdbwebaafc1 hpdbweb 
# ... assuming this username, password, and database name (defined in .yml file)
```

### Cleanly restart the database
"Have you tried turning it off and on again?"

* Drop the database.
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
  oc exec -i -n aafc-labs-can-dev deployment/hpdb-db -- mysql -u hpdb_user -phpdbwebaafc1 hpdbweb   < mysql-dump/hpdb.sql
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

# TROUBLESHOOTING

## 6. Monitoring Application Logs

```bash
oc logs -f deployment/hpdb-app
```
## "Application is not available", yet both pods are running
The hpdb-mysql-pvc may still be attached to an old database pod, preventing new one from attaching. This is likely to happen after a rollout restart. 

To fix:
* Delete the old pod
* Restart the database deployment

## Restoring the application to a version that "WORKED EARLIER"
* Revert on GitLab to a branch you KNOW worked earlier:
  * Create a backup copy of your project directory on your local machine, just in case!
  * On GitLab:
    * Go to the branch you're using
    * Click "History"
    * Click the title of a commit you know worked
    * Go to options -> revert
    * Choose the branch you want to revert to and click "revert"
  * Use `git pull` to pull the old commit to your local branch.
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
