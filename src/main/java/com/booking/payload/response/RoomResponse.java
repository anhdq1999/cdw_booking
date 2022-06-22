package com.booking.payload.response;

import com.booking.entity.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Builder
public class RoomResponse {
    Long id;
    String name;
    String shortDescription;
    String description;
    double price;
    int rating;
    int numRating;
    boolean status;
    Address address;
    CategoryEntity category;
    List<ReviewResponse> reviews;
    List<GalleryResponse> images;
    UserEntity user;
}
