package com.booking.converter;

import com.booking.entity.RoleEntity;
import com.booking.payload.request.RoleRequest;
import com.booking.payload.response.RoleResponse;

public class RoleConverter {
    private static RoleConverter INSTANCE;
    public static RoleConverter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RoleConverter();
        }
        return INSTANCE;
    }
    public RoleResponse toResponse(RoleEntity entity){
        return RoleResponse.builder()
                .name(entity.getName())
                .build();
    }
    public RoleEntity toEntity(RoleRequest entity){
        return RoleEntity.builder()
                .name(entity.getName())
                .build();
    }
}
