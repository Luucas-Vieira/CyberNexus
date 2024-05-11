
FROM maven:3.8.4-openjdk-17 as build
WORKDIR /app
COPY . /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/cybernexus-0.0.1-SNAPSHOT.jar /app
RUN --mount=type=cache,id=s/59d37361-6156-4090-9422-e1a7bf451fa8-m2/repository,target=/app/.m2/repository mvn -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install
ENTRYPOINT ["java","-jar","/app/cybernexus-0.0.1-SNAPSHOT.jar"]
