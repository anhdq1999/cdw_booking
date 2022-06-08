package com.booking.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String fullName;
    @Column
    private Calendar dateOfBirth;
    @Column
    private String gender;
    @Column
    private String phoneNumber;

    @OneToOne(mappedBy = "address")
    private Address address;

    private String roles;

}
