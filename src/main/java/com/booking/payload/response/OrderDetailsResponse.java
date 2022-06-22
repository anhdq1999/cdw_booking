package com.booking.payload.response;

import com.booking.entity.RoomEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
public class OrderDetailsResponse {
    Long id;
    RoomEntity roomEntity;
    int adults;
    int child;
    int infants;
    Date checkIn;
    Date checkOut;
    String note;
    double price;
}
