package com.booking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private UserEntity user;

    private String country;
    private String province;
    private String district;
    private String ward;
    private String street;
    private String googleAddress;

    public Address(UserEntity user, String country, String province, String district, String ward, String street, String googleAddress) {
        this.user = user;
        this.country = country;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.street = street;
        this.googleAddress = googleAddress;
    }
}
