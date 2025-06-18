FROM docker.io/andrianrf/spring-builder AS builder
WORKDIR /app
COPY . .
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw clean package -DskipTests

FROM registry.access.redhat.com/ubi9/openjdk-21
LABEL name="va-gateway" \
      vendor="andrianrf" \
      maintainer="Andrian Ramadhan Febriana <andrian.r.febriana@gmail.com>" \
      version="1.0.0" \
      summary="va-gateway" \
      description="va-gateway"
ENV TZ="Asia/Jakarta"
COPY --from=builder /app/target/*.jar app.jar
USER 1000
EXPOSE 8080
#HEALTHCHECK --interval=12h --timeout=10s --start-period=10s --retries=3 CMD curl --fail http://localhost:8089/backoffice-be/actuator/health || exit 1
ENTRYPOINT ["java", "-jar", "app.jar","-Djava.net.preferIPv4Stack=true"]