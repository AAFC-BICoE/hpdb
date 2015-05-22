#Host-Pathogen Web Service API

##Description
This is a the Restful Web Service develop for Host-Pathogen Database from AAFC-ACC Departement.

##Requirement:
```
Building the project using Maven3
Note: needs java >= v1.7
```

##Build
```
Step by Step Instructions
mvn -DskipTests clean compile assembly:single
java ca.gc.agr.mbb.hostpathogen.ws.Main
```

##Run Data:
```
export CLASSPATH=target/HostPathWS-1.0-SNAPSHOT-jar-with-dependencies.jar
java ca.gc.agr.mbb.hostpathogen.ws.Main
Starts web server on port 8080
```

##URLs to Try on these Object
```
1-Hosts
2-Pathogens
3-HostPathogens
4-Locations
5-References
6-Authors
```
##return meta data header
```
http://localhost:8080/v1/
```

##return list of records
```
http://localhost:8080/v1/hosts/
http://localhost:8080/v1/pathogens/
http://localhost:8080/v1/hostpathogens/
http://localhost:8080/v1/authors/
http://localhost:8080/v1/references
http://localhost:8080/v1/locations/
```

##Get a single container record by primary key:
```
http://localhost:8080/v1/hosts/1/
http://localhost:8080/v1/pathogens/1/
http://localhost:8080/v1/hostpathogens/1/
http://localhost:8080/v1/authors/1/
http://localhost:8080/v1/locations/1/
```

##Credit
Agriculture and Agri-food Canada
