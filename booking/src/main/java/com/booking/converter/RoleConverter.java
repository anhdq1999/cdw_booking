package com.example.cdweb.HotelBookingAPI.converter;

import com.example.cdweb.HotelBookingAPI.entity.Role;
import com.example.cdweb.HotelBookingAPI.payload.request.RoleRequest;
import com.example.cdweb.HotelBookingAPI.payload.response.RoleResponse;

public class RoleConverter {
    private static RoleConverter INSTANCE;
    public static RoleConverter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RoleConverter();
        }
        return INSTANCE;
    }
    public RoleResponse toResponse(Role entity){
        return RoleResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }
    public Role toEntity(RoleRequest entity){
        return Role.builder()
                .name(entity.getName())
                .code(entity.getCode())
                .build();
    }
}
