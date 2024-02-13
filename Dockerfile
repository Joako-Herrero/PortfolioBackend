FROM amazoncorretto:17-alpine-jdk
MAINTAINER MJH
COPY target/portfoliomjh-0.0.1-SNAPSHOT.jar  portfoliomjh-app.jar
ENTRYPOINT ["java","-jar","/portfoliomjh-app.jar"]
