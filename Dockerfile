FROM adoptopenjdk/openjdk14:alpine-jre
WORKDIR /opt
COPY target/nwta-0.0.1.jar application.jar
EXPOSE 8888
CMD ["java", "-jar", "application.jar"]