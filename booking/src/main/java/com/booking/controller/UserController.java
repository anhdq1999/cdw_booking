package com.example.cdweb.HotelBookingAPI.controller;


import com.example.cdweb.HotelBookingAPI.config.Response;
import com.example.cdweb.HotelBookingAPI.entity.User;
import com.example.cdweb.HotelBookingAPI.payload.request.UserRequest;
import com.example.cdweb.HotelBookingAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<User> users =userService.getAll();
        return ResponseEntity.ok(Response.success("Get all user successfully",users));
    }
    @PostMapping()
    public ResponseEntity<?> createUser(){
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, UserRequest userRequest){
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return null;
    }
    public ResponseEntity<?> getOneById(@PathVariable Long id){ return null;}

}
