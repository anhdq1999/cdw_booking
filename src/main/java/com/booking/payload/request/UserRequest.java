package com.booking.payload.request;

import com.booking.entity.RoleEntity;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
