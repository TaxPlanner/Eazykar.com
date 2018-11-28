FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    EZKR_SLEEP=0 \
    JAVA_OPTS=""

RUN adduser -D -s /bin/sh eazykaruser
WORKDIR /home/eazykaruser

COPY entrypoint.sh entrypoint.sh
ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown eazykaruser:eazykaruser entrypoint.sh
USER eazykaruser

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080

ADD *.war app.war

