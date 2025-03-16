FROM openjdk:17-jdk
COPY target/pokeapplication.jar pokeapplication.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","pokeapplication.jar"]