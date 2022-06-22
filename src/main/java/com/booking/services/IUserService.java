package com.booking.services;

import com.booking.entity.UserEntity;
import com.booking.payload.response.UserAppResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<UserAppResponse> getAll();

    //
//    UserAppResponse findById(Long id);
//
    UserEntity save(UserEntity userEntity);

//    UserAppResponse save(UserAppRequest userAppRequest);
//
//    UserApp edit(Long id, UserAppRequest userAppRequest);
//
//    void delete(Long id);


}
