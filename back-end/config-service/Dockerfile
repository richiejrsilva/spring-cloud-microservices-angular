from openjdk:8u151-jre-alpine3.7

COPY ./target/*.jar /usr/config-service.jar
WORKDIR /usr

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "/usr/config-service.jar"]