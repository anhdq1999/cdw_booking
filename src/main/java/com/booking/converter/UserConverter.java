package com.booking.converter;

import com.booking.entity.UserEntity;
import com.booking.payload.request.UserAppRequest;
import com.booking.payload.response.UserAppResponse;

public class UserConverter {
    private static UserConverter instance;

    public static UserConverter getInstance() {
        if (instance == null) {
            instance = new UserConverter();
        }
        return instance;
    }

    public UserAppResponse toResponse(UserEntity entity) {
        return UserAppResponse.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .roleEntities(entity.getRoleEntities())
                .build();
    }

    public UserEntity toEntity(UserAppRequest userRequest) {
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
