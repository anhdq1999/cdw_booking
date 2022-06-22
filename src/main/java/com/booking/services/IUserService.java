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
//    List<UserEntity>getAll();


    UserResponse findById(Long id);

    UserResponse update(Long id, UserRequest request);


    UserEntity save(UserEntity userEntity);


    void delete(Long id);


}
