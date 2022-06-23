package com.booking.controller.admin;


import com.booking.common.Response;
import com.booking.entity.UserEntity;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.services.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin/users")
@PreAuthorize("hasRole('ADMIN')")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        List<UserResponse> listUsers = userService.getAll();
        return ResponseEntity.ok(Response.success("Get all users successfully", listUsers));
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        Optional<UserEntity> userResponse = userService.findByUsername(username);
        return ResponseEntity.ok(Response.success("get User by id successfully", userResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.update(id, userRequest);
        log.info("[UserController] User Response : {}", userResponse);
        return ResponseEntity.ok(Response.success("Update User by id successfully", userResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok(Response.success("Delete by id successfully", null));
    }
}
