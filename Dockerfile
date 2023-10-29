FROM eclipse-temurin:17

WORKDIR /app

COPY target/CRUDApp-0.0.1-SNAPSHOT.jar /app/CRUDApp-0.0.1.jar

ENTRYPOINT ["java", "-jar", "CRUDApp-0.0.1.jar"]