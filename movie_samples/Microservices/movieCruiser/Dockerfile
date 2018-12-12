FROM openjdk:10-jdk
ADD ./target/movieCruiser-0.0.1-SNAPSHOT.jar /usr/src/movieCruiser-0.0.1-SNAPSHOT.jar
WORKDIR usr/src	
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/usr/src/movieCruiser-0.0.1-SNAPSHOT.jar"]

