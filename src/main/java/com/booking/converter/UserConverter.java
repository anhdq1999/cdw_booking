package com.booking.converter;

import com.booking.entity.User;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;

public class UserConverter {
    private static UserConverter instance;
    public static UserConverter getInstance(){
        if(instance==null){
            instance=new UserConverter();
        }
        return instance;
    }
    public UserResponse toResponse(User entity){
        return UserResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .role(entity.getRole())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
    public User toEntity(UserRequest entity){
        return User.builder()
                .fullName(entity.getFullName())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }


}
