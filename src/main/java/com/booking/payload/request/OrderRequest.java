package com.booking.payload.request;

import com.booking.entity.OrderDetailsEntity;
import com.booking.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private OrderDetailsEntity orderDetailsEntity;
    private String status;
    private String paymentMethod;
    private Double taxPrice;
    private Double totalPrice;
    private UserEntity user;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paidAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date refundAt;
    private String customerName;
    private String customerPhone;
}

