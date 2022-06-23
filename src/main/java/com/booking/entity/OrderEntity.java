package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity userEntity;

    String status;
    double tax_price;
    double total_price;
    @Temporal(TemporalType.TIMESTAMP)
    Date paidAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date refundAt;
    String customer_name;
    String customer_phone;
//
//    @OneToMany(mappedBy = "orders")
//    private Set<OrderDetailsEntity> listOrderDetails;
}

