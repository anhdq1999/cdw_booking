package com.booking.converter;

import com.booking.entity.ProvinceEntity;
import com.booking.payload.request.ProvinceRequest;
import com.booking.payload.response.ProvinceResponse;

import java.util.stream.Collectors;

public class ProvinceConverter {
    public static ProvinceEntity toEntity(ProvinceRequest request) {
        return ProvinceEntity.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .nameWithType(request.getNameWithType())
                .type(request.getType())
                .build();
    }

    public static ProvinceResponse toResponse(ProvinceEntity entity) {
        return ProvinceResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .nameWithType(entity.getNameWithType())
                .slug(entity.getSlug())
                .type(entity.getType())
                .districts(
                        entity.getDistricts() != null ?
                                (entity.getDistricts()
                                        .stream().map(district -> DistrictConverter.toResponse(district))
                                        .collect(Collectors.toList()))
                                : null
                )
                .build();
    }
}
