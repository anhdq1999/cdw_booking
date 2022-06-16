package com.booking.converter;

import com.booking.entity.UserApp;
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

    public UserAppResponse toResponse(UserApp entity) {
        return UserAppResponse.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .roles(entity.getRoles())
                .build();
    }

    public UserApp toEntity(UserAppRequest userRequest) {
        return UserApp.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .fullName(userRequest.getFullName())
                .phoneNumber(userRequest.getPhoneNumber())
                .address(userRequest.getAddress())
                .roles(userRequest.getRoles())
                .build();
    }
}
