HostPathogenLuceneIndexer
=========================

Create Lucene index from CSV file of Host-Pathogen data



Creating index
================

* build the package

`mvn clean package`

* Export the `PATH` info. I am cheating using my maven cache:

`export CLASSPATH=/home/newtong/.m2/repository/org/apache/lucene/lucene-queryparser/4.8.1/lucene-queryparser-4.8.1.jar:/home/newtong/.m2/repository/ca/gc/agr/mbb/hostpathogen/hostpathogenlucenesearcher/hostpathogenlucenesearcher/1.0-SNAPSHOT/hostpathogenlucenesearcher-1.0-SNAPSHOT.jar:/home/newtong/.m2/repository/org/apache/commons/commons-csv/1.0/commons-csv-1.0.jar:/home/newtong/work/HostPathogenLuceneIndexer/target/hostPathogenLuceneIndexer-1.0-SNAPSHOT.jar:/home/newtong/.m2/repository/org/apache/lucene/lucene-core/4.10.0/lucene-core-4.10.0.jar:/home/newtong/.m2/repository/org/apache/lucene/lucene-analyzers-common/4.10.0/lucene-analyzers-common-4.10.0.jar`

* Run the code. Make sure the built JAR is in your `PATH`:

`java ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader.Main PATH_TO_CSV_FILES  DESTINATION_LUCENE_INDEX_DIR`



