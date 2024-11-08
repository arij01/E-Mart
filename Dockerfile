FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/customer-service-1.0.0.jar customer-service-1.0.0.jar
ENTRYPOINT ["java","-jar","customer-service-1.0.0.jar"]