package com.example.cdweb.HotelBookingAPI.repository;

import com.example.cdweb.HotelBookingAPI.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
