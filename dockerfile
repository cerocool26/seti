FROM openjdk:17-jdk

# Copiar el gradle-wrapper.jar y otros archivos necesarios
COPY gradle/wrapper/gradle-wrapper.jar .
COPY gradlew .
COPY gradle/ ./gradle
COPY build.gradle .

# Asegurarte de que el script gradlew tenga permisos de ejecución
RUN chmod +x gradlew

# Comando de entrada para ejecutar el wrapper de Gradle
ENTRYPOINT ["./gradlew"]
