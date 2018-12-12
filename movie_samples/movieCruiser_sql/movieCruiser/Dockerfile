FROM openjdk:10-jdk
ENV MYSQL_DATABASE=db
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=password
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/db
ADD ./target/movieCruiser-0.0.1-SNAPSHOT.jar /usr/src/movieCruiser-App-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src
EXPOSE 8080
ENTRYPOINT ["java","-jar", "movieCruiser-0.0.1-SNAPSHOT.jar"]

