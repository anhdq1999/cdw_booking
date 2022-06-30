package com.booking.payload.request;

import com.booking.payload.request.roomResquest.RoomGalleryRequest;
import com.booking.payload.request.roomResquest.RoomReviewRequest;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class RoomRequest {
    String name;
    String shortDescription;
    String description;
    double price;
    int rating;
    int numRating;
    boolean status;
    AddressRequest address;
    List<RoomGalleryRequest> images;
    List<RoomReviewRequest> reviews;
    Long categoryId;
    Long userId;
}
