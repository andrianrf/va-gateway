FROM openjdk:11.0.14.1-jdk

# add curl for curl to google maps
RUN #apk add curl

RUN apk add tzdata
ENV TZ Asia/Jakarta

COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]