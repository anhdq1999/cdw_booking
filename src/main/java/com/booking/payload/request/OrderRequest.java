package com.booking.payload.request;

import com.booking.entity.OrderDetailsEntity;
import com.booking.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderDetailsEntity> orderDetailsEntity;
    private String status;
    private String paymentMethod;
    private Double taxPrice;
    private Double totalPrice;
    private UserEntity user;
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date paidAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date refundAt;
    private String customerName;
    private String customerPhone;
}

