FROM openjdk:8-jdk-alpine

EXPOSE 9000

ARG JAR_FILE=/target/*.jar

COPY ${JAR_FILE} application.jar

RUN echo "Creating docker image of application"

LABEL maintainer="harshshah1295@gmail.com"

ENTRYPOINT ["java", "-jar", "application.jar"]
