FROM maven:3.9.4-eclipse-temurin-17-alpine as build
RUN mkdir /booking
WORKDIR /booking
COPY ./target/HotelBookingAPI-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["mvn","spring-boot:run"]
