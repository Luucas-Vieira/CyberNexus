FROM openjdk:graalvm-jdk-17.0.11-7.1
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

