package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id",nullable = false)
    RoomEntity roomEntity;
    int adults;
    int child;
    int infants;
    @Temporal(TemporalType.TIMESTAMP)
    Date checkIn;
    @Temporal(TemporalType.TIMESTAMP)
    Date checkOut;
    String note;
    double price;
}
