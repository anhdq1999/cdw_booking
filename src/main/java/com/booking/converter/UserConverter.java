package com.booking.converter;

import com.booking.entity.UserEntity;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import org.springframework.stereotype.Component;

@Component

public class UserConverter {
    private static UserConverter instance;

    public static UserConverter getInstance() {
        if (instance == null) {
            instance = new UserConverter();
        }
        return instance;
    }

    public UserResponse toResponse(UserEntity entity) {
        return UserResponse.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .roleEntities(entity.getRoleEntities())
                .build();
    }

    public UserEntity toEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .fullName(userRequest.getFullName())
                .phoneNumber(userRequest.getPhoneNumber())
                .address(userRequest.getAddress())
                .roleEntities(userRequest.getRoleEntities())
                .build();
    }
}
