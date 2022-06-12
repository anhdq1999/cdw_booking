package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User user;
    private String shortDescription;
    private Double price;
    private Integer rating;
    private Integer numReviews;
    private Boolean status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "address_id")
    private Address address;


}
