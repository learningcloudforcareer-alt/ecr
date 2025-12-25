# Build stage
FROM eclipse-temurin:17 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew && ./gradlew build -x test

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]