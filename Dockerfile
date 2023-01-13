FROM openjdk:11
ADD ../target/naijagigs4me-v1.jar naijagigs4me-v1.jar
ENTRYPOINT ["java","-jar", "naijagigs4me-v1.jar"]
EXPOSE 8080