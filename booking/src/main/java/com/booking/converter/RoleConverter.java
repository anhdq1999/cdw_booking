package com.booking.converter;

import com.booking.entity.Role;
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
