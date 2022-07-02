package com.booking.services.impl;

import com.booking.converter.UserConverter;
import com.booking.constant.ERole;
import com.booking.entity.RoleEntity;
import com.booking.entity.UserEntity;
import com.booking.payload.request.SignupRequest;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.repository.RoleRepository;
import com.booking.repository.UserRepository;
import com.booking.security.services.UserDetailsImpl;
import com.booking.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<UserEntity> getAll() {

        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not found by id: "+id));
    }


    public UserEntity getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found by id:" + id));
    }

    @Override
    public UserEntity save(UserRequest request) {
        RoleEntity role = roleRepository.findByName("USER");
        if(request.getRoleId()==null) request.setRoleId(role.getId());
        String hash_password = encoder.encode(request.getPassword());
        request.setPassword(hash_password);
        UserEntity entity = UserConverter.toEntity(request);
        return userRepository.save(entity);

    }

    @Override
    public UserEntity update(Long id,UserRequest request){
        String hash_password = encoder.encode(request.getPassword());
        request.setPassword(hash_password);
        UserEntity entity = UserConverter.toEntity(request);
        entity.setId(id);
        return userRepository.save(entity);
    }
    @Override
    public void deleteById(Long id){
        UserEntity entity = getById(id);
        userRepository.delete(entity);
    }
}
