package com.booking.converter;

import com.booking.entity.RoomEntity;
import com.booking.payload.request.RoomRequest;
import com.booking.payload.response.RoomResponse;

import java.util.stream.Collectors;

public class RoomConverter {
    public static RoomResponse toResponse(RoomEntity roomEntity){
      return  RoomResponse.builder()
                .id(roomEntity.getId())
                .description(roomEntity.getDescription())
                .shortDescription(roomEntity.getShortDescription())
                .name(roomEntity.getName())
                .status(roomEntity.isStatus())
                .user(roomEntity.getUser())
                .images(roomEntity.getImages().stream()
                        .map((gallery)->GalleryConverter.toResponse(gallery))
                        .collect(Collectors.toList()))
                .reviews(roomEntity.getReviews().stream()
                        .map(review->ReviewConverter.toResponse(review))
                        .collect(Collectors.toList()))
                .address(roomEntity.getAddress())
                .category(roomEntity.getCategory())
                .rating(roomEntity.getRating())
                .price(roomEntity.getPrice())
                .build();
    }
    public static RoomEntity toEntity(RoomRequest roomRequest){
        return RoomEntity.builder()
                .description(roomRequest.getDescription())
                .shortDescription(roomRequest.getShortDescription())
                .name(roomRequest.getName())
                .numRating(roomRequest.getNumRating())
                .rating(roomRequest.getRating())
                .status(roomRequest.isStatus())
                .price(roomRequest.getPrice())
                .build();
    }
}
