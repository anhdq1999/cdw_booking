package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)

    private UserEntity userEntity;

    private String status;

    private Double tax_price;

    private Double total_price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paidAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date refundAt;

    private String customer_name;

    private String customer_phone;

    @OneToMany(targetEntity = OrderDetailsEntity.class, fetch = FetchType.LAZY)
    private Collection<OrderDetailsEntity> listOrderDetails;
}

