package com.booking.model.dto;

import com.booking.model.Address;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private Calendar dateOfBirth;
    private String gender;
    private String phoneNumber;
    private Address address;
    private String roles;
}
