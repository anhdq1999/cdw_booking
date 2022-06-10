package com.booking.service;

import com.booking.payload.response.UserResponse;

import java.util.List;

public interface IUserService {
    UserResponse save();

    List<UserResponse> findAll();

    UserResponse findById(Long id);

}
