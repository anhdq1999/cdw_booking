package com.booking.converter;

import com.booking.entity.RoleEntity;
import com.booking.entity.UserEntity;
import com.booking.payload.request.SignupRequest;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.payload.response.roomRespsonse.RoomUserResponse;

public class UserConverter {


    public static UserResponse toResponse(UserEntity entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .role(RoleConverter.toResponse(entity.getRoleEntity()))
                .build();
    }

    public static UserEntity toEntity(UserRequest userRequest) {
        RoleEntity role = RoleEntity.builder()
                .id(userRequest.getRoleId())
                .build();
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .fullName(userRequest.getFullName())
                .phoneNumber(userRequest.getPhoneNumber())
                .address(userRequest.getAddress())
                .roleEntity(role)
                .build();
    }

    public static UserEntity toEntity(SignupRequest request) {
        return UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .build();
    }

    public static RoomUserResponse toRoomResponse(UserEntity entity) {
        return RoomUserResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .build();
    }

}
