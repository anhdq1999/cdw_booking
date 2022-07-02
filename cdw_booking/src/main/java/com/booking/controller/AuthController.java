package com.booking.controller;

import com.booking.common.Response;
import com.booking.converter.UserConverter;
import com.booking.entity.UserEntity;
import com.booking.payload.request.LoginRequest;
import com.booking.payload.request.SignupRequest;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.JwtResponse;
import com.booking.payload.response.UserResponse;
import com.booking.security.jwt.JwtUtils;
import com.booking.security.services.UserDetailsImpl;
import com.booking.services.impl.AddressService;
import com.booking.services.impl.RoleService;
import com.booking.services.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthority().getAuthority();
        JwtResponse response=new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), role);
        return ResponseEntity.ok(Response.success("Login successfully",response));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request) {
        if (userService.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body(
                    Response.fail("Username is existed")
            );
        }
        if (userService.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(
                    Response.fail("Email is existed")
            );
        }
        UserEntity entity = userService.save(request);
        UserResponse response = UserConverter.toResponse(entity);
        return ResponseEntity.ok(Response.success("User registered successfully!", response));

    }
}
