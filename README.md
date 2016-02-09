# Host Pathogen Database Web Application [![Build Status](https://travis-ci.org/AAFC-MBB/hpdb.svg?branch=dev)](https://travis-ci.org/AAFC-MBB/hpdb)

Agriculture and Agri-Food Canada’s (AAFC) internally developed Host Pathogen Database Web Application (hpdb) has been created to give access to the AAFC curated Host-Pathogen Database.  The application currently allows the searching of Host Records, Pathogen Records and Host-Pathogen Records.


Required Software
------------------

    Oracle Java 7+
    MySQL 5.6
    Maven 3.2.5+
    Tomcat 7


Installation
------------

From the command line:

    $ git clone https://github.com/AAFC-MBB/hpdb.git
    $ cd hpdb
    $ mvn install
    
If the build was successful the project tests have run and sample data has been loaded into the mysql database. 

    
Running in Development
----------------------

    $ mvn jetty:run -Dmaven.test.skip=true
    
The web application should now be running at (http://localhost:8080)
    
    
Importing Data
--------------

To import the MS Access database csv files into the mysql database:

    $ mysql -u USERNAME -p PASSWORD hpdbweb < /Importer/import_script.sql


Packaging for Deployment
------------------------

    $ mvn package -Dmaven.test.skip=true 
 
 This will create hpdb.war which you can insert into your container application.


Contact
-------

    Project Group email: mbb@agr.gc.ca
    Project Developer: Satpal Bilkhu - Satpal.Bilkhu@agr.gc.ca
