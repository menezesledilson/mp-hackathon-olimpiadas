# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie o arquivo JAR para o diretório de trabalho
COPY target/olympic-0.0.1-SNAPSHOT.jar /app/app.jar

# Defina o comando para executar o JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exponha a porta que a aplicação vai usar
EXPOSE 8080
