package com.booking.converter;

import com.booking.entity.WardEntity;
import com.booking.payload.request.WardRequest;
import com.booking.payload.response.WardResponse;

public class WardConverter {
    public static WardEntity toEntity(WardRequest request){
        return WardEntity.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .nameWithType(request.getNameWithType())
                .type(request.getType())
                .path(request.getPath())
                .pathWithType(request.getPathWithType())
                .build();
    }

    public static WardResponse toResponse(WardEntity entity){
        return WardResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .nameWithType(entity.getNameWithType())
                .slug(entity.getSlug())
                .type(entity.getType())
                .path(entity.getPath())
                .pathWithType(entity.getPathWithType())
                .build();
    }
}
