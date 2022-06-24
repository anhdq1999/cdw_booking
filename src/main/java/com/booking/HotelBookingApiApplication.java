package com.booking;

import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
import com.booking.payload.request.CategoryRequest;
import com.booking.repository.CategoryRepository;
import com.booking.services.impl.CategoryService;
import com.booking.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotelBookingApiApplication {
    @Autowired
    CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository) {
        return args -> {
            CategoryRequest categoryRequest = CategoryRequest.builder()
                    .name("Home Stay")
                    .code("home-stay")
                    .build();
            CategoryRequest categoryRequest1 = CategoryRequest.builder()
                    .name("Villa")
                    .code("villa")
                    .build();
            CategoryRequest categoryRequest2 = CategoryRequest.builder()
                    .name("Resort")
                    .code("resort")
                    .build();
            CategoryRequest categoryRequest3 = CategoryRequest.builder()
                    .name("Hotel")
                    .code("hotel")
                    .build();
            categoryService.save(categoryRequest1);
            categoryService.save(categoryRequest2);
            categoryService.save(categoryRequest3);
            categoryService.save(categoryRequest);
        };
    }
}
