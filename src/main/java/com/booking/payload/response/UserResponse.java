package com.booking.payload.response;

import com.booking.entity.RoleEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Set<RoleEntity> roleEntities;
}
