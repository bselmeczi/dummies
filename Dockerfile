# Stage 1
FROM openjdk:17-jdk-slim as buildImg
MAINTAINER dummies.com
WORKDIR /app
COPY . .
RUN ./gradlew bootJar
# ENTRYPOINT ["java","-jar","build/libs/demo-0.0.1-SNAPSHOT.jar"]

# Stage 2 - we don't need a JDK or gradle, using a lightweight JRE + Linux image
FROM eclipse-temurin:17-jre-alpine
# copy from the previous 'build' file system into the target (production) one
COPY --from=buildImg /app/build /app/build

ENTRYPOINT ["java","-jar","/app/build/libs/demo-0.0.1-SNAPSHOT.jar"]