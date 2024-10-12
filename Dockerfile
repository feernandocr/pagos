# Usar una imagen base de OpenJDK para Java 17
FROM openjdk:17-jdk-alpine

# Establecer un directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR desde la carpeta target al directorio de trabajo del contenedor
COPY target/PagosBase-0.0.1-SNAPSHOT.jar /app/PagosBase-0.0.1-SNAPSHOT.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "/app/PagosBase-0.0.1-SNAPSHOT.jar"]