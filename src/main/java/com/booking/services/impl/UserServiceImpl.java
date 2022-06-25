package com.booking.services.impl;

import com.booking.converter.UserConverter;
import com.booking.entity.UserEntity;
import com.booking.payload.request.SignupRequest;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.repository.AddressRepository;
import com.booking.repository.UserRepository;
import com.booking.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    private UserConverter userConverter;


    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> listUserResponse = new ArrayList<>();
        List<UserEntity> listUser = userRepository.findAll();
        for (UserEntity user : listUser) {
            listUserResponse.add(userConverter.toResponse(user));
        }
        return listUserResponse;
    }

    @Override
    public Optional<UserResponse> findById(Long id) {
//        UserEntity user = userRepository.findById(id);
        return null;
    }

    //
//    @Override
//    public UserAppResponse findById(Long id) {
//        UserApp user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found user by id: " + id));
//        return userConverter.toResponse(user);
//    }
//
    @Override
    public UserEntity save(UserRequest request) {
        UserEntity entity =UserConverter.toEntity(request);
        return userRepository.save(entity);
    }



//    @Override
//    public UserAppResponse save(UserAppRequest userAppRequest) {
//        UserApp userApp = userConverter.toEntity(userAppRequest);
//        Address address = userApp.getAddress();
//        addressRepository.save(address);
//        UserApp saved = userRepository.save(userApp);
//        return userConverter.toResponse(saved);
//    }
//    @Override
//    public UserAppResponse edit(Long id, UserAppRequest userAppRequest) {
//////        User userEntity = userConverter.toEntity(userRequest);
////        Optional<UserApp> user = userRepository.findById(id);
////        if (user.isPresent()) {
////            UserApp _user = user.get();
////            _user.setAddress(userRequest.getAddress());
////            _user.setEmail(userRequest.getEmail());
//////            _user.setUsername(userRequest.getUsername()); Khum ai sửa username bao giờ cả
////            _user.setPassword(userRequest.getPassword());
////            _user.setFullName(userRequest.getFullName());
////            _user.setPhoneNumber(userRequest.getPhoneNumber());
////            _user.setRole(userRequest.getRole());
////            userRepository.save(_user);
////            return userConverter.toResponse(_user);
////        }
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
////
////    public List<UserResponse> getAll() {
////        List<UserResponse> userResponseList = new ArrayList<>();
////        List<User> listUser = userRepository.findAll();
////        for (User user : listUser) {
////            userResponseList.add(userConverter.getInstance().toResponse(user));
////        }
////        return userResponseList;
////    }
////
////    public User insert(UserRequest userRequest) {
////        User user = UserConverter.getInstance().toEntity(userRequest);
////        return userRepository.save(user);
////    }
////
////    public User update(Long id, UserRequest userRequest) {
////        User userFound = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found user by id: " + id));
////        User user = User.builder()
////                .fullName(userRequest.getFullName())
////                .username(userRequest.getUsername())
////                .email(userRequest.getEmail())
////                .address(userRequest.getAddress())
////                .phoneNumber(userRequest.getPhoneNumber())
////                .password(userRequest.getPassword())
////                .role(userRequest.getRole())
////                .build();
////        return user;
////    }

}
