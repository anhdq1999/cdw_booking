package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderDetails")
@Builder
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
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

    public OrderDetailsEntity(RoomEntity roomEntity, int adults, int child, int infants, Date checkIn, Date checkOut, String note, double price) {
        this.roomEntity = roomEntity;
        this.adults = adults;
        this.child = child;
        this.infants = infants;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.note = note;
        this.price = price;
    }
}
