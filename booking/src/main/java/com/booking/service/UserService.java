package com.example.cdweb.HotelBookingAPI.service;

import com.example.cdweb.HotelBookingAPI.converter.UserConverter;
import com.example.cdweb.HotelBookingAPI.entity.User;
import com.example.cdweb.HotelBookingAPI.payload.request.UserRequest;
import com.example.cdweb.HotelBookingAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User insert(UserRequest userRequest){
       User user= UserConverter.getInstance().toEntity(userRequest);
        return userRepository.save(user);
    }
    public boolean update(Long id, UserRequest userRequest){
       User user= userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found user by id: "+id));
       User.builder()
               .fullName(userRequest.getFullName())
               .username(userRequest.getUsername())
               .email(userRequest.getEmail())
               .address(userRequest.getAddress())
               .phoneNumber(userRequest.getPhoneNumber())
               .password(userRequest.getPassword())
               .role(userRequest.getRole())
               .build();
       return false;
    }
    public boolean delete(Long id){
            return false;
    }
    public User getById(Long id){
        return null;
    }
}
