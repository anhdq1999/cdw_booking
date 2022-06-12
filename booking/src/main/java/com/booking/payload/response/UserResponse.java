package com.booking.payload.response;

import com.booking.entity.Address;
import com.booking.entity.Role;
import com.booking.entity.Room;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private Address address;
    private Role role;
    private List<Room> listRoom;
}
