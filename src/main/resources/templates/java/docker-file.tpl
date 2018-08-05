FROM java:8-jre
MAINTAINER ${System.getProperty("user.name")}

ENV SERVER_PORT 8000
EXPOSE 8000

#Local DB config
ENV SPRING_DATASOURCE_DRIVERCLASSNAME org.postgresql.Driver
ENV SPRING_DATASOURCE_JDBCURL jdbc:postgresql://localhost:5432/personalization
ENV SPRING_DATASOURCE_USERNAME xxxxxxxx
ENV SPRING_DATASOURCE_PASSWORD xxxxxxxx

#Container setup
RUN mkdir /app
COPY ./build/libs/${projectName}-service-0.1.0.jar /app/

WORKDIR /app
CMD java -Dsun.net.inetaddr.ttl=0 -jar ${projectName}-service-0.1.0.jar