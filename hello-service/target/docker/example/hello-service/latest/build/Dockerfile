FROM openjdk
ARG JAR_FILE=target/hello-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} hello-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/hello-service-1.0-SNAPSHOT.jar"]
