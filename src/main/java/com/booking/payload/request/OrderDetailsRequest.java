package com.booking.payload.request;

import com.booking.entity.RoomEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkIn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkOut;
    private String note;
    private Double price;
}
