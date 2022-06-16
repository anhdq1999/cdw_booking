package com.booking.payload.response;

import com.booking.entity.Address;
import com.booking.entity.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UserAppResponse {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private Address address;
    private Set<Role> roles;
}
