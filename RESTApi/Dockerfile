FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/easykarrest-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} easykarrest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easykarrest-0.0.1-SNAPSHOT.jar"]
