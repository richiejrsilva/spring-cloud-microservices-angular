from openjdk:8u151-jre-alpine3.7

COPY ./target/*.jar /usr/user-service.jar
WORKDIR /usr

ENTRYPOINT ["java", "-jar", "/usr/user-service.jar"]