package com.booking.converter;

import com.booking.entity.GalleryEntity;
import com.booking.payload.request.GalleryRequest;
import com.booking.payload.response.GalleryResponse;

public class GalleryConverter {
    public static GalleryResponse toResponse(GalleryEntity entity){
        return GalleryResponse.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .build();
    }
    public static GalleryEntity toEntity(GalleryRequest galleryRequest){
        return GalleryEntity.builder()
                .url(galleryRequest.getUrl())
                .build();
    }
}
