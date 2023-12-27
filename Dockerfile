FROM openjdk:17
COPY target/quoteWeb-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "quoteWeb-0.0.1-SNAPSHOT.jar"]
