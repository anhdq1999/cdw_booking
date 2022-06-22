package com.booking.payload.request;

import com.booking.entity.Address;
import com.booking.entity.CategoryEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomRequest {
    Long id;

    String name;
    String shortDescription;
    String description;
    double price;
    int rating;
    int numRating;
    boolean status;
    Long addressId;
    Long categoryId;
    Long hostId;
}
