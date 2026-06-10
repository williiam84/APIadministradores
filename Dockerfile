FROM eclipse-temurin:17-jdk

WORKDIR /app

# instala maven
RUN apt-get update && apt-get install -y maven

COPY . .

RUN mvn clean package -DskipTests

# verifica o jar gerado
RUN ls -la target

EXPOSE 8080

# pega o jar explicitamente (SEM *)
CMD ["sh", "-c", "java -jar target/*.jar"]