FROM maven:3.6.3-jdk-8

WORKDIR /project

ADD pom.xml /project

ADD . /project

RUN mvn clean package -Dmaven.test.skip=true

FROM tomcat:8.5.88-jre8-temurin-focal

COPY --from=0 /project/target/hostpathogen.web-*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

ENTRYPOINT ["catalina.sh", "run"]