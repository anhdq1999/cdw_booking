package com.example.cdweb.HotelBookingAPI.entity;

import lombok.*;
import java.util.List;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Role extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false,unique = true)
    String name;
    String code;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
    private List<User> users;
}
