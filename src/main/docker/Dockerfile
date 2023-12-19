
FROM openjdk:17-alpine

MAINTAINER Yami Veranes <yami.veranes@gmail.com>

ARG artifactname

WORKDIR /gft
ADD ${artifactname}.jar /gft/app.jar
EXPOSE 8080

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /gft/app.jar"]