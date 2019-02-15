from openjdk:8u151-jre-alpine3.7

COPY ./target/*.jar /usr/auth-service.jar
WORKDIR /usr

ENTRYPOINT ["java", "-jar", "/usr/auth-service.jar"]
