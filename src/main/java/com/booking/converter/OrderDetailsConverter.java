package com.booking.converter;

import com.booking.entity.OrderDetailsEntity;
import com.booking.payload.request.OrderDetailsRequest;
import com.booking.payload.response.OrderDetailsResponse;

public class OrderDetailsConverter {
    private static OrderDetailsConverter instance;

    public static OrderDetailsConverter getInstance() {
        if (instance == null) {
            instance = new OrderDetailsConverter();
        }
        return instance;
    }

    public OrderDetailsResponse toResponse(OrderDetailsEntity entity) {
        return OrderDetailsResponse.builder()
                .id(entity.getId())
                .roomEntity(entity.getRoomEntity())
                .adults(entity.getAdults())
                .child(entity.getChild())
                .infants(entity.getInfants())
                .checkIn(entity.getCheckIn())
                .checkOut(entity.getCheckOut())
                .note(entity.getNote())
                .price(entity.getPrice())
                .build();
    }

    public OrderDetailsEntity toEntity(OrderDetailsRequest request) {
        return OrderDetailsEntity.builder()
                .roomEntity(request.getRoom())
                .adults(request.getAdults())
                .child(request.getChild())
                .infants(request.getInfants())
                .checkIn(request.getCheckIn())
                .checkOut(request.getCheckOut())
                .note(request.getNote())
                .price(request.getPrice())
                .build();
    }
}
