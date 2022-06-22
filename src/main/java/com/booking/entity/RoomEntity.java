package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String name;
    String shortDescription;
    String description;
    double price;
    int rating;
    int numRating;
    boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
           @JoinColumn(name = "address_id",nullable = false)
    Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    CategoryEntity category;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    List<ReviewEntity> reviews;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "roomEntity")
    List<GalleryEntity> images;
    @ManyToOne
    @JoinColumn(name = "host_id",nullable = false)
     UserEntity user;

}
