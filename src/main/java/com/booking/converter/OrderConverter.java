package com.booking.converter;

import com.booking.entity.OrderEntity;
import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;

public class OrderConverter {
    private static OrderConverter instance;

    public static OrderConverter getInstance() {
        if (instance == null) {
            instance = new OrderConverter();
        }
        return instance;
    }

    public OrderResponse toResponse(OrderEntity entity) {
        return OrderResponse.builder()
                .userEntity(entity.getUserEntity())
                .status(entity.getStatus())
                .tax_price(entity.getTax_price())
                .total_price(entity.getTotal_price())
                .paidAt(entity.getPaidAt())
                .refundAt(entity.getRefundAt())
                .customerName(entity.getCustomer_name())
                .customerPhone(entity.getCustomer_phone())
                .build();
    }

    public OrderEntity toEntity(OrderRequest orderRequest) {
        return OrderEntity.builder()
                .userEntity(orderRequest.getUser())
                .status(orderRequest.getStatus())
                .tax_price(orderRequest.getTaxPrice())
                .total_price(orderRequest.getTotalPrice())
                .paidAt(orderRequest.getPaidAt())
                .refundAt(orderRequest.getPaidAt())
                .customer_name(orderRequest.getCustomerName())
                .customer_phone(orderRequest.getCustomerPhone())
                .build();
    }
}
