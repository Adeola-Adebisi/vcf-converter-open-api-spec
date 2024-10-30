FROM eclipse-temurin:21-jdk AS build
RUN apt-get update && apt-get install -y maven
COPY . .
RUN mvn clean install

FROM eclipse-temurin:21-jdk
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
