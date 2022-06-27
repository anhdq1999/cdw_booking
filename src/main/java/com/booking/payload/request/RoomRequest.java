package com.booking.payload.request;

import com.booking.converter.ReviewConverter;
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
    List<GalleryRequest> images;
    List<ReviewRequest> reviews;
    Long categoryId;
    Long userId;
}
