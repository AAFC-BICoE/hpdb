FROM openjdk:8

# Install Java and Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /project

ADD . /project

# Build the project using Maven with Java 8
RUN mvn clean package -Dmaven.test.skip=true

CMD ["bash", "-c", "mvn jetty:run"]

# Expose the default Jetty port
EXPOSE 8080