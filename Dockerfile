FROM gradle:6.6.1-jdk11 AS grdl

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN --mount=type=cache,id=gradle,target=/home/gradle/.gradle  gradle build --no-daemon -x test

RUN mkdir /app
RUN mkdir /v-sql9

COPY --from=grdl /home/gradle/src/build/libs/*.jar\
       /app/spring-boot-application.jar

ENTRYPOINT [\
  "java",\
  "-XX:+UseContainerSupport",\
  "-XX:-UseAdaptiveSizePolicy",\
  "-Xmx128m",\
  "-Xms32m",\
  "-Xss256k",\
  "-Djava.security.egd=file:/dev/./urandom",\
  "-jar",\
  "/app/spring-boot-application.jar"]

#FROM openjdk:12-jdk-alpine
#RUN mkdir mgstest
#WORKDIR mgstest
#COPY . .
#EXPOSE 9000/tcp
#ENTRYPOINT ["java", "-jar", "build/libs/mgstest-0.0.1.jar"]
