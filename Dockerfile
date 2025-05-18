FROM openjdk:21-slim
LABEL authors="javacodewiz"
WORKDIR /app
COPY target/product-service.jar product-service.jar
EXPOSE 7400
ENTRYPOINT ["java", "-jar","product-service.jar"]