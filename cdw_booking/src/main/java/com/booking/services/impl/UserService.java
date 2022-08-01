package com.booking.services.impl;

import com.booking.converter.UserConverter;
import com.booking.entity.PasswordResetToken;
import com.booking.entity.RoleEntity;
import com.booking.entity.UserEntity;
import com.booking.payload.request.CheckPasswordResetTokenRequest;
import com.booking.payload.request.ResetPasswordRequest;
import com.booking.payload.request.UserRequest;
import com.booking.repository.RoleRepository;
import com.booking.repository.UserRepository;
import com.booking.services.IUserService;
import com.booking.services.email.FormMail;
import com.booking.services.email.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MailService mailService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

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
                .orElseThrow(() -> new IllegalArgumentException("Not found by id: " + id));
    }


    public UserEntity getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found by id:" + id));
    }

    @Override
    public UserEntity save(UserRequest request) {
        RoleEntity role = roleRepository.findByName("USER");
        if (request.getRoleId() == null) request.setRoleId(role.getId());
        String hash_password = encoder.encode(request.getPassword());
        request.setPassword(hash_password);
        UserEntity entity = UserConverter.toEntity(request);
        return userRepository.save(entity);

    }

    @Override
    public UserEntity update(Long id, UserRequest request) {
        String hash_password = encoder.encode(request.getPassword());
        request.setPassword(hash_password);
        UserEntity entity = UserConverter.toEntity(request);
        entity.setId(id);
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        UserEntity entity = getById(id);
        userRepository.delete(entity);
    }


    public void forgotPassword(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("Email is not existed " + email));
        String token = UUID.randomUUID().toString();
        passwordResetTokenService.createPasswordResetTokenForUser(userEntity, token);
        mailService.sendMail(email, "Reset password", FormMail.forgotPassword(userEntity.getId(), token));
    }


    @Transactional
    public boolean resetPassword(ResetPasswordRequest request) {
        boolean validation = passwordResetTokenService.validatePasswordResetToken(request.getToken());
        if (validation) {
            String hash_password = encoder.encode(request.getNewPassword());
            userRepository.updatePasswordById(request.getId(), hash_password);
            passwordResetTokenService.deleteByToken(request.getToken());
            return true;
        }else{
            return false;
        }
    }
    public boolean checkPasswordResetToken(CheckPasswordResetTokenRequest request){
        PasswordResetToken passwordResetToken=passwordResetTokenService.findByTokenAndUserId(request.getToken(),request.getId());
        System.out.println(request);
        if(passwordResetToken!=null) return true;
        return false;
    }


}
