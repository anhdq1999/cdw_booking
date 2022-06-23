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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortDescription;
    private String description;
    private double price;
    private int rating;
    private int numRating;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<ReviewEntity> reviews;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity")
    private List<GalleryEntity> images;
    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private UserEntity user;

}
