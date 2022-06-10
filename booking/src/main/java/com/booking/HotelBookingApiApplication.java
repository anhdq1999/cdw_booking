package com.example.cdweb.HotelBookingAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotelBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApiApplication.class, args);
	}

}
