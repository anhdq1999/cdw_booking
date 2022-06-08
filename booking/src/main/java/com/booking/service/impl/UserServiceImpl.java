package com.booking.service.impl;

import com.booking.model.dto.UserDTO;
import com.booking.repositories.UserRepository;
import com.booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
