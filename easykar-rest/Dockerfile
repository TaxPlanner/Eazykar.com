FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/easykar-rest-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} easykar-rest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easykar-rest-0.0.1-SNAPSHOT.jar"]
