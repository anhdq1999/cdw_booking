package com.booking.model.mapper;

import com.booking.model.User;
import com.booking.model.dto.UserDTO;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        UserDTO userTemp = new UserDTO();
        userTemp.setId(user.getId());
        userTemp.setUsername(user.getUsername());
        userTemp.setEmail(user.getEmail());
        userTemp.setFullName(user.getFullName());
        userTemp.setDateOfBirth(user.getDateOfBirth());
        userTemp.setGender(user.getGender());
        userTemp.setAddress(user.getAddress());
        userTemp.setRoles(user.getRoles());

        return userTemp;
    }
}
