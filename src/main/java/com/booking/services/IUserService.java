package com.booking.services;

import com.booking.entity.UserEntity;
import com.booking.payload.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<UserResponse> getAll();


    Optional<UserResponse> findById(Long id);

    //
    UserEntity save(UserEntity userEntity);

//    UserAppResponse save(UserAppRequest userAppRequest);
//
//    UserApp edit(Long id, UserAppRequest userAppRequest);
//
//    void delete(Long id);


}
