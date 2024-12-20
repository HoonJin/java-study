FROM amazoncorretto:17.0.8

ARG NAME
COPY ./${NAME}/build/libs/${NAME}-*-SNAPSHOT.jar ./app.jar
EXPOSE 8080:8080
CMD ["java", "-jar", "app.jar"]
