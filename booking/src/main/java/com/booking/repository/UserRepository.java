package com.example.cdweb.HotelBookingAPI.repository;

import com.example.cdweb.HotelBookingAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
