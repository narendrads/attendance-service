FROM openjdk:17-jdk
EXPOSE 9093
ADD target/attendance-service.jar attendance-service.jar
ENTRYPOINT ["java","-jar","/attendance-service.jar"]
