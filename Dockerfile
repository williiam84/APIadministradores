FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests
RUN ls -la target

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]