#!/bin/sh

echo "The application will start in ${EZKR_SLEEP}s..." && sleep ${EZKR_SLEEP}
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -cp /app/resources/:/app/classes/:/app/libs/* "com.eazykar.portal.EazykarApp"  "$@"
