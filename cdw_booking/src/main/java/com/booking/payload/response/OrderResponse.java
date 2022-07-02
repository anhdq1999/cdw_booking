package com.booking.payload.response;

import com.booking.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Builder
public class OrderResponse {
    Long id;
    UserEntity userEntity;
    String status;
    double tax_price;
    double total_price;
    Date paidAt;
    Date refundAt;
    String customer_name;
    String customer_phone;
    List<OrderDetailsResponse> orderDetails;
}
