# Base image using JDK 17 slim variant
FROM openjdk:17 AS build

# Set a working directory in the Docker image
WORKDIR /application

# Copy the Maven executable and Maven settings
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file and source code
COPY pom.xml .
COPY src src

# Build the application using Maven wrapper and skip tests
RUN ./mvnw package -DskipTests

# Use a slim version for the runtime
FROM openjdk:17

# Copy the built jar file from the build stage to the /app directory
COPY --from=build /application/target/*.jar /app/app.jar

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Expose the port the app runs on
EXPOSE 8080
