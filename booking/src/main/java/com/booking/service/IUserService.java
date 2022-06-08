package com.booking.service;

import com.booking.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<UserDTO> findAll();
}
