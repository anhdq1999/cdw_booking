package com.booking.services;

import com.booking.entity.UserEntity;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<UserResponse> getAll();

    UserResponse update(Long id, UserRequest request);

    Optional<UserResponse> findById(Long id);


    UserEntity save(UserEntity userEntity);


    void delete(Long id);


}
