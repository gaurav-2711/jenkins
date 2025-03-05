# Use a lightweight base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Accept profile argument from build
ARG PROFILE=default
ENV SPRING_PROFILES_ACTIVE=$PROFILE

# Copy the application JAR file (matches the final name from pom.xml)
COPY target/jenkins-0.0.1-SNAPSHOT.jar app.jar

# Run the application with the active profile
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
