package com.example.cdweb.HotelBookingAPI.payload.response;

import com.example.cdweb.HotelBookingAPI.entity.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Role role;
}
