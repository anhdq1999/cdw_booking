package com.example.cdweb.HotelBookingAPI.payload.request;

import com.example.cdweb.HotelBookingAPI.entity.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Role Role;
}
