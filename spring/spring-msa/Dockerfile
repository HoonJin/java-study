FROM amazoncorretto:21.0.5

ARG PATH
COPY ./${PATH}/build/libs/*-SNAPSHOT.jar ./app.jar
EXPOSE 8080:8080
CMD ["java", "-jar", "app.jar"]
