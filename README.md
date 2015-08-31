# Host-PathogenDB
Host-Pathogen Project

##Host-Pathogen Database
This project is been divide in 5 modules:
Nouns: This Class is a POJO Class for all project object.
Lucene Indexer : This Module will created a Lucene index from CSV file of Host-Pathogen Database.
Lucene searcher: This module will query the indexer to return the data.
Rest-Jersey base web Service expose the data from lucene.
Java Web apllication user interface to interacted with the web service and display result from the queries.

##Quick summary
Agriculture and Agri-Food Canada’s posessing large database called Host-Pathogen DataBase includes a collection database that provide detailed information on relationship, interaction and disease between an host (Plants) and a pathogen (fungal, bacteria, viral or nematodes) from publish scientist paper, books or journal across the global and mainly in North America. This project main goal is to build a search engine for the database.


##Technology stack
Oracle Java 8
Maven 3
Tomcat 7, jetty or grizzly
Eclipse 
Lucene 4.10

##How to set up the environment
1. Build Index from CSV
2. Call WS
3. created WAR

##How to build  and deploy the project
Lucene Index: creating LuceneIndex from CSV file
1- Download the CSV file from redmine #4750
2- build the Package  “mvn clean package”
3- Export the PATH info using maven cache: 
export CLASSPATH=/home/tranthitv/.m2/repository/org/apache/lucene/lucene-queryparser/4.8.1/lucene-queryparser-4.8.1.jar:/home/tranthitv/.m2/repository/ca/gc/agr/mbb/hostpathogen/hostpathogenlucenesearcher/hostpathogenlucenesearcher/1.0-SNAPSHOT/hostpathogenlucenesearcher-1.0-SNAPSHOT.jar:/home/tranthitv/.m2/repository/org/apache/commons/commons-csv/1.0/commons-csv-1.0.jar:/home/tranthitv/work/HostPathogenLuceneIndexer/target/hostPathogenLuceneIndexer-1.0-SNAPSHOT.jar:/home/tranthitv/.m2/repository/org/apache/lucene/lucene-core/4.10.0/lucene-core-4.10.0.jar:/home/tranthitv/.m2/repository/org/apache/lucene/lucene-analyzers-common/4.10.0/lucene-analyzers-common-4.10.0.jar
4- Run the code and make sure the build JAR is in your PATH

java ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader.Main PATH_TO_CSV_FILES_SAVE DESTINATION_LUCENE_INDEX_DIR

##Lucene Searcher: Main Application to return the search object
1- Make sur the lucene build index located in the project root directory
2- Build the project JAR with “mvn clean package”

##HPDB Rest-Jersey Web Service: Expose Lucene Data to the Web Application
1- To build the project “mvn clear install ”
2- To deploye the Web Service “run the main class with java ca.gc.agr.mbb.hostpathogen.ws.Main”

##HPDB Web Service App: User Interface
1- To build the project “mvn clear package ”
2- To deploye the Web “mvn jetty:run-war”
3- Try to View the query throw “http:localhost:8080/hpdb/”
