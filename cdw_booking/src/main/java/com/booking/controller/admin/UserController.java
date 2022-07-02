package com.booking.controller.admin;


import com.booking.common.Response;
import com.booking.converter.UserConverter;
import com.booking.entity.UserEntity;
import com.booking.exception.ExceptionControllerHandle;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends ExceptionControllerHandle {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(Response.success("Get all users successfully", userService.getAll()));
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserEntity entity = userService.getById(id);
        UserResponse response = UserConverter.toResponse(entity);
        return ResponseEntity.ok(Response.success("Get user by id successfully",response));
    }
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody UserRequest userRequest){
        UserEntity entity= userService.save(userRequest);
        UserResponse response =UserConverter.toResponse(entity);
        return ResponseEntity.ok(Response.success("Create user successfully",response));
    }

    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody UserRequest request){
        UserEntity entity = userService.update(id,request);
        UserResponse response=UserConverter.toResponse(entity);
        return ResponseEntity.ok(Response.success("Update user with id: "+id+"successfully",response));
    }
}
