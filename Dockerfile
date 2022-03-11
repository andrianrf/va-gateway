FROM openjdk:11-jre-slim

# add curl for curl to google maps
# RUN apk add curl

ENV TZ="Asia/Jakarta"

COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]