FROM openjdk:25-ea-4-jdk-oraclelinux9
WORKDIR /app
COPY target/*.jar target/mp2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/mp2.jar"]