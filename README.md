# Host Pathogen Database Web Application [![Build Status](https://travis-ci.org/AAFC-BICoE/hpdb.svg?branch=dev)](https://travis-ci.org/AAFC-BICoE/hpdb)

Agriculture and Agri-Food Canada’s (AAFC) internally developed Host Pathogen Database Web Application (hpdb) has been created to give access to the AAFC curated Host-Pathogen Database.  The application currently allows the searching of Host Records, Pathogen Records and Host-Pathogen Records.


Required Software
------------------

    Oracle Java 8
    MySQL 5.6
    Maven 3.2.5+
    Tomcat 7


Installation
------------

From the command line:

    $ git clone https://github.com/AAFC-BICoE/hpdb.git
    $ cd hpdb
    $ mvn install
    
If the build was successful the project tests have run and sample data has been loaded into the mysql database. 

    
Running in Development
----------------------

    $ mvn jetty:run -Dmaven.test.skip=true
    
The web application should now be running at http://localhost:8080
    
    
Importing Data
--------------

To import the MS Access database csv files into the mysql database:

    $ mysql -u USERNAME -p PASSWORD hpdbweb < /Importer/import_script.sql


Packaging for Deployment
------------------------

    $ mvn package -Dmaven.test.skip=true 
 
 This will create hpdb.war which you can insert into your container application.
 
Docker Deployment
-----------------

Docker compose can be used to spin up this app and its required mysql 5.7 database. Here are the steps necessary to do this:

    1. Ensure that a db dump of hpdb is in the mysql-dump folder with the following lines prepended to the dump:
        $ CREATE DATABASE hpdbweb
        $ USE hpdbweb
    2. Build the defined services in Docker compose
        $ sudo docker compose build
    3. Run the built services
        $ docker compose up

This should result in the database container spinning up and importing the slightly modified mysql dump and the app container running the app. Once ready,
it can be accessed at http://localhost:8080
 

Contact
-------

    Project Group email: mbb@agr.gc.ca
    Project Developer: Satpal Bilkhu - Satpal.Bilkhu@agr.gc.ca
