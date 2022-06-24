package com.booking.controller.admin;


import com.booking.common.Response;
import com.booking.converter.UserConverter;
import com.booking.entity.UserEntity;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(Response.success("Get all users successfully", userService.getAll()));
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
//        return ResponseEntity.ok(Response.success("Get user"))
        return null;
    }
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody UserRequest userRequest){
        UserEntity entity= userService.save(userRequest);
        UserResponse response =UserConverter.toResponse(entity);
        if(entity!=null) return ResponseEntity.ok(Response.success("Create user successfully",response));
        return ResponseEntity.internalServerError().body("fail");
    }


}
