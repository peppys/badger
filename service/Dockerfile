# Step 1: Build jar file
FROM maven:3.6.2-jdk-8 AS build

WORKDIR /opt/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Unsets maven config from base image, allowing us to use ./mvnw
ENV MAVEN_CONFIG=""

# Compile jar and save reference to file
RUN ./mvnw install -DskipTests

# Step 2: Use build to containerize jar file
FROM openjdk:8-jdk-alpine

COPY --from=build /opt/app/target/badger-service-0.0.1-SNAPSHOT.jar /opt/app/badger-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/opt/app/badger-service-0.0.1-SNAPSHOT.jar"]
