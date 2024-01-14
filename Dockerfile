# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at the working directory
COPY build/libs/todo-1.0-SNAPSHOT.jar /app/todo.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "todo.jar"]
