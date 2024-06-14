FROM openjdk:17
LABEL authors="labazov"
WORKDIR /app
COPY target/SpringSecurityWithKeycloak-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]