package com.booking.service.impl;

import com.booking.converter.UserConverter;
import com.booking.entity.User;
import com.booking.payload.response.UserResponse;
import com.booking.repository.UserRepository;
import com.booking.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public List<UserResponse> findAll() {
        List<UserResponse> listUserResponse = new ArrayList<>();
        List<User> listUser = userRepository.findAll();
        for (User user : listUser) {
            listUserResponse.add(userConverter.toResponse(user));
        }
        return listUserResponse;
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found user by id: " + id));
        UserResponse userResponse = userConverter.toResponse(user);
        return userResponse;
    }

//
//    public List<UserResponse> getAll() {
//        List<UserResponse> userResponseList = new ArrayList<>();
//        List<User> listUser = userRepository.findAll();
//        for (User user : listUser) {
//            userResponseList.add(userConverter.getInstance().toResponse(user));
//        }
//        return userResponseList;
//    }
//
//    public User insert(UserRequest userRequest) {
//        User user = UserConverter.getInstance().toEntity(userRequest);
//        return userRepository.save(user);
//    }
//
//    public User update(Long id, UserRequest userRequest) {
//        User userFound = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found user by id: " + id));
//        User user = User.builder()
//                .fullName(userRequest.getFullName())
//                .username(userRequest.getUsername())
//                .email(userRequest.getEmail())
//                .address(userRequest.getAddress())
//                .phoneNumber(userRequest.getPhoneNumber())
//                .password(userRequest.getPassword())
//                .role(userRequest.getRole())
//                .build();
//        return user;
//    }

}
