
FROM maven:3.8.4-openjdk-17 as build
WORKDIR /app
COPY . /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/cybernexus-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-jar","/app/cybernexus-0.0.1-SNAPSHOT.jar"]
