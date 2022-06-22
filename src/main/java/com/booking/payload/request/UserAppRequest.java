package com.booking.payload.request;

import com.booking.entity.Address;
import com.booking.entity.RoleEntity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UserAppRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private Address address;
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
