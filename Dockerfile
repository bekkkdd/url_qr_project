

# Build stage
FROM gradle:8-jdk17-jammy AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle clean build --no-daemon

# Package stage
FROM openjdk:20-ea-17-slim-buster
COPY --from=build /home/gradle/src/build/libs/UrlQrProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]