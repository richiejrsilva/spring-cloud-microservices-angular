from openjdk:8u151-jre-alpine3.7

COPY ./target/*.jar /usr/discovery-service.jar
WORKDIR /usr

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/usr/discovery-service.jar"]