FROM openjdk:11-jre-slim
RUN mkdir /app
WORKDIR /app

ADD ./target/calm-0.0.1.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]