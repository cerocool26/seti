FROM openJdk:17-jdk
COPY gradle/gradle-wrapper.jar
ENTRYPOINT ["java","-jar","gradle-wrapper.jar"]