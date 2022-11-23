FROM openjdk:11
VOLUME /tmp
ADD /build/libs/javaapi-1.0.0.jar javaapi-1.0.0.jar
ENTRYPOINT ["java", "-jar", "javaapi-1.0.0.jar"]