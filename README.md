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

Docker compose can be used to spin up this app and its required mysql 5.6 database. Here are the steps necessary to do this:

    1. Spin up the both the db and app containers
        $ docker compose up
    2. Attach to the db container and manually load the hpdb.sql dump found within
        $ mysql -u root hpdbweb < hpdb.sql

Once these steps are complete, the site can be accessed at http://localhost:8080.

NOTE: the jdbc info has been hardcoded to fit the services in the docker-compose.yml. To run this in an IDE, it will need to be reverted to prior settings found at: 

https://github.com/AAFC-BICoE/hpdb/blob/62bdd41f711657e3880e5e5717430cadc4142abd/src/main/resources/jdbc.properties 

and 

https://github.com/AAFC-BICoE/hpdb/blob/62bdd41f711657e3880e5e5717430cadc4142abd/src/main/resources/applicationContext-resources.xml
 

Contact
-------

    Project Group email: mbb@agr.gc.ca
    Project Developers: Karim Tahan - Karim.Tahan@agr.gc.ca,  Satpal Bilkhu - Satpal.Bilkhu@agr.gc.ca
