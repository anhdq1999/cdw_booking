package com.booking.controller;

import com.booking.common.Response;
import com.booking.converter.AddressConverter;
import com.booking.converter.UserConverter;
import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
import com.booking.entity.UserEntity;
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
    AddressServiceImpl addressServiceImpl;

    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder encoder;
    private UserConverter userConverter;
    private AddressConverter addressConverter;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(Response.success("Login successfully ", new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        UserEntity user = new
                UserEntity(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword())
                , signUpRequest.getFullName(), signUpRequest.getPhoneNumber(), signUpRequest.getAddress()
        );

        Set<String> strRoles = signUpRequest.getRole();
        Set<RoleEntity> roleEntities = new HashSet<>();


        if (strRoles == null) {
            RoleEntity userRoleEntity = roleService.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roleEntities.add(userRoleEntity);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        RoleEntity adminRoleEntity = roleService.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roleEntities.add(adminRoleEntity);
                        break;
                    case "host":
                        RoleEntity hostRoleEntity = roleService.findByName(ERole.ROLE_HOST).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roleEntities.add(hostRoleEntity);
                        break;
                    default:
                        RoleEntity userRoleEntity = roleService.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roleEntities.add(userRoleEntity);
                }
            });
        }
        user.setRoleEntities(roleEntities);
        UserEntity userEntity = userService.save(user);
        return ResponseEntity.ok(Response.success("Create user successfully", userEntity));
    }

}
