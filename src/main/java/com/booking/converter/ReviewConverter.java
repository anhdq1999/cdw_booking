package com.booking.converter;

import com.booking.entity.ReviewEntity;
import com.booking.payload.request.ReviewRequest;
import com.booking.payload.response.ReviewResponse;

public class ReviewConverter {
    public static ReviewResponse toResponse(ReviewEntity entity){
        return ReviewResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .comment(entity.getComment())
                .rating(entity.getRating())
                .build();
    }
    public static ReviewEntity toEntity(ReviewRequest entity){
        return ReviewEntity.builder()
                .name(entity.getName())
                .comment(entity.getComment())
                .rating(entity.getRating())
                .build();
    }

}
