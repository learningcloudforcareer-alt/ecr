FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy all files
COPY . .

# Make gradlew executable and build
RUN chmod +x ./gradlew && ./gradlew bootJar --no-daemon

EXPOSE 8080

CMD ["java", "-jar", "build/libs/kotlin-jwt-login-0.0.1-SNAPSHOT.jar"]