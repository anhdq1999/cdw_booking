package com.booking.controller;

import com.booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    @Autowired
    private IUserService IUserService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        return null;
    }

}
