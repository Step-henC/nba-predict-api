# First stage: build the application
FROM maven:3-eclipse-temurin-17 AS build
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests

# Second stage: create a slim image
FROM openjdk:17.0-jdk
COPY --from=build /app/target/predict-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]