# Use a base image with Maven and JDK installed
FROM maven:3.8.2-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the source code to the container
COPY . .

# Package the application as a WAR file using Maven
RUN mvn clean package -DskipTests

# Expose the port your Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Start the Spring Boot application when the container starts
CMD ["java", "-jar", "target/spring_boot_backend_template-0.0.1.jar"]
