FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8888
ARG JAR_FILE=target/webeasykar-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} webeasykar-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/webeasykar-0.0.1-SNAPSHOT.jar"]
