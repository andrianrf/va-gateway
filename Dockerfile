FROM registry.access.redhat.com/ubi9/openjdk-11:1.15-1
MAINTAINER Andrian Ramadhan Febriana <andrian.r.febriana@gmail.com>

LABEL name="va-gateway" \
      vendor="andrianrf" \
      maintainer="andrianrf" \
      version="1.0.0" \
      summary="va-gateway" \
      description="va-gateway"

RUN mkdir "log"
ENV TZ="Asia/Jakarta"
COPY target/*.jar app.jar

USER 1000

EXPOSE 8080

HEALTHCHECK CMD curl --fail http://localhost:8080/va-gateway/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar","-Djava.net.preferIPv4Stack=true"]