FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/data-collector-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]