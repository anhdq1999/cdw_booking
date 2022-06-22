package com.booking;

import com.booking.entity.ERole;
import com.booking.entity.Role;
import com.booking.services.impl.RoleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotelBookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleServiceImpl roleRepository) {
        return args -> {
            Role roleUser = new Role(ERole.ROLE_USER);
            Role roleAdmin = new Role(ERole.ROLE_ADMIN);
            Role roleHost = new Role(ERole.ROLE_HOST);
            roleRepository.save(roleUser);
            roleRepository.save(roleAdmin);
            roleRepository.save(roleHost);

        };
    }
}
