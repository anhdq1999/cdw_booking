package com.booking.payload.request.roomResquest;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomReviewRequest {
    String name;
    String comment;
    int rating;
}
