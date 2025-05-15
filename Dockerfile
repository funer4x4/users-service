FROM eclipse-temurin:17-jdk-jammy

COPY examen-liverpool-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]