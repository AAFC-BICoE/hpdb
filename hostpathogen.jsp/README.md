# HostPathogenJSP

#Description
This is a JSP Servlet for the project “HostPathogenWS” for Agriculture and Agri-Food Department. The Servlet will view the jsp form.

#Build
mvn clean package
mvn compile assembly:single

#Run servlet on Jetty
mvn jetty:run

Start the client jsp on port 8080

#URLs to load form 
Use a broswer to connect http://localhost:8080/ and static hello page will be loading. Try 
http://localhost:8080/search/ this will get into the form jsp page 
