package com.booking.service.impl;

import com.booking.converter.UserConverter;
import com.booking.entity.User;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.repository.UserRepository;
import com.booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    private UserConverter userConverter;

    @Override
    public List<UserResponse> getAll() {
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
        return userConverter.toResponse(user);
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User userEntity = userConverter.toEntity(userRequest);
        userRepository.save(userEntity);
        return userConverter.toResponse(userEntity);
    }

    @Override
    public UserResponse edit(Long id, UserRequest userRequest) {
//        User userEntity = userConverter.toEntity(userRequest);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User _user = user.get();
            _user.setAddress(userRequest.getAddress());
            _user.setEmail(userRequest.getEmail());
//            _user.setUsername(userRequest.getUsername()); Khum ai sửa username bao giờ cả
            _user.setPassword(userRequest.getPassword());
            _user.setFullName(userRequest.getFullName());
            _user.setPhoneNumber(userRequest.getPhoneNumber());
            _user.setRole(userRequest.getRole());
            userRepository.save(_user);
            return userConverter.toResponse(_user);
        }
        return null;
    }

    @Override
    public void delete(Long id) {

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
