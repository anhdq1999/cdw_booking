package com.booking.payload.request;

import com.booking.entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsRequest {
    private RoomEntity room;
    private Integer adults;
    private Integer child;
    private Integer infants;
    private Date checkIn;
    private Date checkOut;
    private String note;
    private Double price;
}
