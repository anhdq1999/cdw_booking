package com.booking.payload.response;

import com.booking.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class OrderResponse {
    private Long id;
    private UserEntity userEntity;
    private String status;
    private double tax_price;
    private double total_price;
    private Date paidAt;
    private Date refundAt;
    private String customerName;
    private String customerPhone;
    private List<OrderDetailsResponse> orderDetails;
}
