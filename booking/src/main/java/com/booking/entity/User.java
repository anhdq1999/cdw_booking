package com.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class User extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;


}
