package com.booking.payload.request;

import com.booking.entity.Address;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
//    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
//    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
//    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String fullName;

    @NotBlank
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Set<String> role;
}
