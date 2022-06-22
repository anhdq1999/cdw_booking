package com.booking.payload.request;

import com.booking.entity.Address;
import com.booking.entity.Role;
import lombok.*;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UserAppRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private Address address;
    private Set<Role> roles = new HashSet<>();
}
