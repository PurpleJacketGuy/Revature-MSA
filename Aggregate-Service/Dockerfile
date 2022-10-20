
FROM maven:3.8.5-openjdk-8 AS MAVEN_BUILD_STAGE 

COPY ./ ./

RUN mvn clean package 

FROM openjdk:8-jre 

COPY --from=MAVEN_BUILD_STAGE /target/Aggregate-Service-0.0.1-SNAPSHOT.jar /aggregator.jar 

CMD ["java", "-jar", "aggregator.jar"]