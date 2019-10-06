FROM openjdk:8-jdk-alpine
EXPOSE 9005
VOLUME /tmp
ADD /build/libs/productStore.jar productStore.jar
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:/dev/./urandom","/productStore.jar"]