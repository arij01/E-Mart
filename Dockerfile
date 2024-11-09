# Use an official JDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

EXPOSE 8090
# Copy the JAR file to the container
COPY target/Rahma-0.0.1-SNAPSHOT.jar /app/Rahma.jar

# Specify the command to run your app
CMD ["java", "-jar", "/app/Rahma.jar"]
