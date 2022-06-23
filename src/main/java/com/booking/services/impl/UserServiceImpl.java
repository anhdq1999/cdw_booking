package com.booking.services.impl;

import com.booking.converter.UserConverter;
import com.booking.entity.UserEntity;
import com.booking.payload.request.UserRequest;
import com.booking.payload.response.UserResponse;
import com.booking.repository.AddressRepository;
import com.booking.repository.UserRepository;
import com.booking.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserConverter userConverter;

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
        log.info("[UserServiceImpl] list users : {} ", listUser);
        for (UserEntity user : listUser) {
            listUserResponse.add(userConverter.toResponse(user));
        }
        log.info("[UserServiceImpl] list usersResponse : {} ", listUserResponse);

        return listUserResponse;
    }


    @Override
    public UserResponse update(Long id, UserRequest request) {
        UserEntity userEntity = userConverter.toEntity(request);
        Optional<UserEntity> userFound = userRepository.findById(id);
        if (userFound.isPresent()) {
            userEntity.setId(userFound.get().getId());
            userEntity.setRoleEntities(userFound.get().getRoleEntities());
            userEntity.setPassword(userFound.get().getPassword());
            UserEntity userEntitySaved = userRepository.save(userEntity);
            return userConverter.toResponse(userEntitySaved);
        }
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found User by id" + id));
        return userConverter.toResponse(userEntity);
    }


    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
