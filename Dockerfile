FROM openjdk:17
EXPOSE 8761
ADD target/discovery-1.0.0.jar discovery-1.0.0.jar
ENTRYPOINT ["java","-jar","discovery-1.0.0.jar"]