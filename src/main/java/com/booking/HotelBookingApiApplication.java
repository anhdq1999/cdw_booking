package com.booking;

import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
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
            RoleEntity roleEntityUser = new RoleEntity(ERole.ROLE_USER);
            RoleEntity roleEntityAdmin = new RoleEntity(ERole.ROLE_ADMIN);
            RoleEntity roleEntityHost = new RoleEntity(ERole.ROLE_HOST);
            roleRepository.save(roleEntityUser);
            roleRepository.save(roleEntityAdmin);
            roleRepository.save(roleEntityHost);

        };
    }
}
