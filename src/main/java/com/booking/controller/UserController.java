package com.booking.controller;


import com.booking.common.Response;
import com.booking.payload.request.UserAppRequest;
import com.booking.payload.response.UserAppResponse;
import com.booking.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<UserAppResponse> users = userService.getAll();
        return ResponseEntity.ok(Response.success("Get all user successfully", users));
    }

    @PostMapping()
    public ResponseEntity<?> createUser() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, UserAppRequest userAppRequest) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return null;
    }

    public ResponseEntity<?> getOneById(@PathVariable Long id) {
        return null;
    }

}
