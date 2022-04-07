FROM openjdk:12-jdk-alpine
RUN mkdir mgstest
WORKDIR mgstest
COPY . .
EXPOSE 9000/tcp
ENTRYPOINT ["java", "-jar", "build/libs/mgstest-0.0.1.jar"]
