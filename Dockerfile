FROM docker.io/library/maven:3.6.3-jdk-8 AS builder
WORKDIR /project

# 1) Copy only pom.xml first
COPY pom.xml .

# 2) Download dependencies (cached unless pom.xml changes)
RUN mvn -B dependency:go-offline

# 3) Copy source code last
COPY src ./src

# 4) Build
RUN mvn -B package -Dmaven.test.skip=true


# Stage 2-- Create the runtime image with Tomcat
FROM docker.io/library/tomcat:8.5.88-jre8-temurin-focal
# Clean out the default files and copy over the ROOT war:
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=0 /project/target/hostpathogen.web-*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
# Create app-specific writable directory
RUN mkdir -p /var/lib/hpdb-search-index && \
    chgrp -R 0 /var/lib/hpdb-search-index && \
    chmod -R g=u /var/lib/hpdb-search-index && \
    chmod -R g+rwX /var/lib/hpdb-search-index
RUN mkdir -p /var/lib/mysql \
 && chgrp -R 0 /var/lib/mysql \
 && chmod -R g+rwX /var/lib/mysql \
 && mkdir -p /docker-entrypoint-initdb.d  \
 && chgrp -R 0 /docker-entrypoint-initdb.d \
 && chmod -R g+rwX /docker-entrypoint-initdb.d
# Give needed tomcat directories write access
RUN chgrp -R 0 \
        /usr/local/tomcat/temp \
        /usr/local/tomcat/work \
        /usr/local/tomcat/logs \
        /usr/local/tomcat/webapps \
        /usr/local/tomcat/conf && \
    chmod -R g=u \
        /usr/local/tomcat/temp \
        /usr/local/tomcat/work \
        /usr/local/tomcat/logs \
        /usr/local/tomcat/webapps \
        /usr/local/tomcat/conf && \
    chmod -R g+rwX \
        /usr/local/tomcat/temp \
        /usr/local/tomcat/work \
        /usr/local/tomcat/logs \
        /usr/local/tomcat/webapps \
        /usr/local/tomcat/conf
# This environment variable tells Tomcat to expand the WAR in a way that is more compatible 
ENV CATALINA_OPTS="-Dorg.apache.catalina.security.SecurityListener.UMASK=002"
ENTRYPOINT ["catalina.sh", "run"]