package com.booking.service;

import com.booking.payload.request.UserAppRequest;
import com.booking.payload.response.UserAppResponse;

import java.util.List;

public interface IUserService {
    List<UserAppResponse> getAll();

    UserAppResponse findById(Long id);

    UserAppResponse save(UserAppRequest userAppRequest);

    UserAppResponse edit(Long id, UserAppRequest userAppRequest);

    void delete(Long id);


}
