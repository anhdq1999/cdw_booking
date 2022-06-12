package com.booking.payload.request;

import com.booking.entity.Address;
import com.booking.entity.Role;
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
    private Address address;
    private Role role;
}
