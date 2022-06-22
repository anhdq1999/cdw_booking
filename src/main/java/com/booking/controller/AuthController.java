package com.booking.controller;

import com.booking.converter.AddressConverter;
import com.booking.converter.UserConverter;
import com.booking.entity.Address;
import com.booking.entity.ERole;
import com.booking.entity.Role;
import com.booking.entity.UserApp;
import com.booking.payload.request.LoginRequest;
import com.booking.payload.request.SignupRequest;
import com.booking.payload.response.JwtResponse;
import com.booking.payload.response.MessageResponse;
import com.booking.security.jwt.JwtUtils;
import com.booking.security.services.UserDetailsImpl;
import com.booking.services.impl.AddressServiceImpl;
import com.booking.services.impl.RoleServiceImpl;
import com.booking.services.impl.UserServiceImpl;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AddressServiceImpl addressService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private UserConverter userConverter;
    private AddressConverter addressConverter;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        log.info("[AUTH]: SignUpRequest {}: ", signUpRequest);
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        UserApp user = new
                UserApp(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword())
                , signUpRequest.getFullName(), signUpRequest.getPhoneNumber()
        );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        Address addressRequest = signUpRequest.getAddress();
        Address saved = addressService.createAddress(addressRequest);


        log.info("[AUTH]: AddressRequest: {} ", addressRequest);
        log.info("[AUTH]: Add_Saved_ID: {} ", saved.getId());
        user.setAddress(saved);
        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "host":
                        Role hostRole = roleService.findByName(ERole.ROLE_HOST).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(hostRole);
                        break;
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userService.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
