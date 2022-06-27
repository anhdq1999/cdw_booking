package com.booking.services.impl;

import com.booking.converter.UserConverter;
import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
import com.booking.entity.UserEntity;
import com.booking.payload.request.SignupRequest;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.repository.AddressRepository;
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
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> listUserResponse = new ArrayList<>();
        List<UserEntity> listUser = userRepository.findAll();
        for (UserEntity user : listUser) {
            listUserResponse.add(UserConverter.toResponse(user));
        }
        return listUserResponse;
    }

    @Override
    public Optional<UserResponse> findById(Long id) {
//        UserEntity user = userRepository.findById(id);
        return null;
    }
    public UserEntity getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not found by id:"+id));
    }

    @Override
    public UserEntity save(UserRequest request) {
        Optional<RoleEntity> optionalRole =roleRepository.findByName(ERole.valueOf(request.getRoleName()));
        if(optionalRole.isPresent()) {
            String hash_password = encoder.encode(request.getPassword());
            request.setPassword(hash_password);
            UserEntity entity = UserConverter.toEntity(request);
            entity.setRoleEntity(optionalRole.get());
            return userRepository.save(entity);
        }else return null;
    }

    public UserEntity signUp(UserEntity entity) {
        return userRepository.save(entity);
    }
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }


}
