FROM maven:3.8-openjdk-17
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/11-spring-boot-docker-network-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]
