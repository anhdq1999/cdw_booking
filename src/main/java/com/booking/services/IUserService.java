package com.booking.services;

import com.booking.entity.UserApp;
import com.booking.payload.request.UserAppRequest;
import com.booking.payload.response.UserAppResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserApp> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

//    List<UserAppResponse> getAll();
//
//    UserAppResponse findById(Long id);
//
    UserApp save(UserApp userApp);

    UserAppResponse save(UserAppRequest userAppRequest);
//
//    UserApp edit(Long id, UserAppRequest userAppRequest);
//
//    void delete(Long id);


}
