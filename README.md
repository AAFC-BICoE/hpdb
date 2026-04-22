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

Required Software
------------------

    Oracle Java 8
    MySQL 5.6
    Maven 3.2.5+
    Tomcat 7
    Java 8

## Component Details

### 1. Database Layer (MySQL)
*   **Secret (`hpdb-mysql-credentials`):** Stores the database username, password, and database name.
*   **PVC (`hpdb-mysql-pvc`):** Requests 1Gi of persistent storage to ensure database data survives pod restarts.
*   **Deployment (`hpdb-db`):** Runs the `mariadb:10.5` image.
*   **Service (`hpdb-db`):** Internal load balancer that allows the app to communicate with the DB via the hostname `hpdb-db`.

### 2. Application Layer (HPDB)
*   **Deployment (`hpdb-app`):** Runs the HPDB container. It pulls database credentials from the Secret and connects to the database using environment variables.
*   **Service (`hpdb-app-service`):** Internal service mapping port 8080.
*   **Route (`hpdb-route`):** Provides a public URL to access the application from a web browser.

## Environment Variables
The app deployment container uses the following environment variables:

| Variable | Source | Description |
|----------|--------|-------------|
| `MYSQL_USER` | Secret | Database username |
| `MYSQL_PASSWORD` | Secret | Database password |
| `MYSQL_DATABASE` | Secret | Target database name |
| `JAVA_TOOL_OPTIONS` | Static | Loggers for debugging |

# 🚀 Build & Deploy on OpenShift

The application is built using its `Dockerfile` via Docker or Podman, pushed to a container image repo such as Quay, 

## 1. Clone the git repo
```bash
git clone https://github.com/AAFC-BICoE/hpdb.git
```

## 2. (Re)build and push the image (anytime you change source code/dockerfile)
```bash
# From anywhere on your local machine
sudo podman login <image-repo-name> --tls-verify=false

# From directory containing dockerfile on your local machine
sudo podman build -t <image-repo-name>:<tag> . 
# --no-cache flag can ensure build changes update if they don't seem to be updating

sudo <image-repo-name>:<tag> --tls-verify=false
```

## 3. Change values.yaml
Update the values.yaml file to fit your image repository, secrets, etc.

## 4. Install (or upgrade) Helm deployment.
* Move the `helm` directory to somewhere that can access your OpenShift cluster.
* If you haven't already, log in to OpenShift in your terminal.
* From directory where you moved your helm chart:
  ```bash
  # from helm directory
  helm upgrade --install <release-name> . # installs if not existing, upgrades if exists

  # Or to override default values in values.yaml with custom values in another values.*.yaml file
  helm upgrade --install <release-name> -f <filename> .
  
  ```
## 5. Restart deployments

If you already had HPDB deployed on your cluster and are updating it, you may want to restart the deployments to ensure changes take effect.
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
## 6. Upload database data:
Pages that use database data (ie anything besides homepage) will fail until data is uploaded.

Values for mysql credentials can be found in your `helm/values.yaml` file (templated into your secret file).
```bash
# from a terminal logged into your OpenShift cluster, from hpdb directory
oc exec -i -n <openshift-namespace> deployment/hpdb-db -- mysql -u <username> -p<password> <database-name> < mysql-dump/hpdb.sql

# check if it worked
oc exec -n <openshift-namespace> deployment/hpdb-db -- \
  mysql -u <username> -p<password> <database-name> \
  -e "SHOW TABLES;"
  # should show a bunch of tables like app_user, host, hostPathogen... user_role
```

# TROUBLESHOOTING
* Consider that app was switched from mysql5 to mariadb 10.5. Bugs could result from incomplete conversion.

## Monitoring Application Logs

```bash
oc logs -f deployment/hpdb-app
```
## If "Application is not available", yet both pods are running
* Give it fifteen or more seconds. The hpdb-app deployment takes awhile to kick in.
* The hpdb-mysql-pvc may still be attached to an old database pod, preventing new one from attaching. This is likely to happen after a rollout restart. To fix:
  * Delete the old pod
  * Restart the database deployment using `oc rollout restart deployment/hpdb-db`

## Application code isn't updating when I rebuild and push the image
For changes that affect Maven, you may need to rebuild the .war file:
```bash
# From project root

  # you may need to pin to java8:
  export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

  mvn clean
  mvn package -DskipTests
```

## If homepage works but other pages say "Data Access Failure"
* You may not have uploaded the database correctly. Try cleanly restarting the database.
  * If the command that uploads the hpdb.sql file takes less than a second, it may be silently failing. Make sure you include the -i flag to use standard input.

## To cleanly restart the database
* Login to SQL in the hpdb-db pod:
  ```bash
  mysql -u <username> -p<password> <database-name>
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

* From the HPDB directory a terminal logged into your OpenShift cluster, upload the sql file into the database:
  ```bash
  oc exec -i -n <openshift-namespace> deployment/hpdb-db -- mysql -u <username> -p<password> <database-name> < mysql-dump/hpdb.sql
  ```

* Check if it worked:
  * In hpdb-db pod:
    ```bash
    # log out of mysql if logged in:
    exit

    # log in again
    mysql -u <username> -p<password> <database-name> 

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
* Apply your updated helm chart with `helm upgrade --install <release-name> .`
* Use `oc rollout restart` on both deployments.
  * If they have a hard time restarting, scale them down to 0 and back up to 1:
    ```bash
    oc scale deployment/<deployment> --replicas=0

    oc scale deployment/<deployment> --replicas=1
    ```