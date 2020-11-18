FROM openjdk:14

COPY target/access-module-0.0.1-SNAPSHOT.jar /app.jar

CMD ["java", "-jar", "/app.jar"]


