FROM adoptopenjdk/openjdk14:alpine-jre

WORKDIR /opt

COPY NWTA-0.0.1-SNAPSHOT.jar application.jar

CMD ["java", "-jar", "application.jar"]