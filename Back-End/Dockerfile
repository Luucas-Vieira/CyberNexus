FROM openjdk:17-jdk
FROM node:18.19.1-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
