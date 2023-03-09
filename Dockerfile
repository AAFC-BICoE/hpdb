FROM ubuntu:18.04

RUN apt-get update && \
    apt-get -y install iputils-ping

# Install Java and Maven
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk maven && \
    rm -rf /var/lib/apt/lists/*
    
# Install curl
RUN apt-get update && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

# Install Jetty 9.4.26
ENV JETTY_HOME /opt/jetty
ENV PATH $JETTY_HOME/bin:$PATH
RUN mkdir -p "$JETTY_HOME" && \
    cd "$JETTY_HOME" && \
    curl -O https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.26.v20200117/jetty-distribution-9.4.26.v20200117.tar.gz && \
    tar -xvf jetty-distribution-9.4.26.v20200117.tar.gz --strip-components=1 && \
    rm jetty-distribution-9.4.26.v20200117.tar.gz

# Set the JAVA_HOME environment variable
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

WORKDIR /project

ADD . /project

# Build the project using Maven with Java 8
RUN mvn clean install -Dmaven.test.skip=true -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8

# Copy the application WAR file to Jetty's webapps directory
COPY target/hostpathogen.web-*.war $JETTY_HOME/webapps/


CMD ["bash", "-c", "mvn jetty:run"]


# Expose the default Jetty port
EXPOSE 8080
