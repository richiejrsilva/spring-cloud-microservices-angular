from openjdk:8u151-jre-alpine3.7

COPY ./target/*.jar /usr/item-service.jar
WORKDIR /usr

ENTRYPOINT ["java", "-jar", "/usr/item-service.jar"]