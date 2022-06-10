package com.booking.service;

import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;

import java.util.List;

public interface IUserService {
    List<UserResponse> getAll();

    UserResponse findById(Long id);

    UserResponse save(UserRequest userRequest);

    UserResponse edit(Long id, UserRequest userRequest);

    void delete(Long id);


}
