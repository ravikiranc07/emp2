FROM openjdk:11

ADD target/employee-final.jar employee-final.jar
ENTRYPOINT ["java","-jar","employee-final.jar"]