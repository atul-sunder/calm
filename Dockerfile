FROM openjdk:17-jdk-slim
RUN mkdir /app
WORKDIR /app

ADD ./lib/calm-0.0.1.jar /app/app.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]