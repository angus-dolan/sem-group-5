FROM openjdk:latest
COPY ./target/sem-group-5-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "sem-group-5-0.1.0.3-jar-with-dependencies.jar"]
