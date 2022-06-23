package com.booking.payload.request;

import com.booking.entity.OrderDetailsEntity;
import com.booking.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class OrderRequest {
    private OrderDetailsEntity orderDetailsEntity;
    private String status;
    private String paymentMethod;
    private Double taxPrice;
    private Double totalPrice;
    private UserEntity user;
    private Date paidAt;
    private Date refundAt;
    private String customerName;
    private String customerPhone;
}

