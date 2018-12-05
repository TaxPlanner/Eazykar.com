FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/eazykar-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} eazykar-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eazykar-0.0.1-SNAPSHOT.war"]