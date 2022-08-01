package com.booking.services.impl;

import com.booking.converter.PasswordTokenResetConverter;
import com.booking.entity.PasswordResetToken;
import com.booking.entity.UserEntity;
import com.booking.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PasswordResetTokenService {
    @Autowired
    PasswordResetTokenRepository passwordTokenRepository;

    public void createPasswordResetTokenForUser(UserEntity user, String token) {
        PasswordResetToken myToken = PasswordTokenResetConverter.toEntity(token,user);
        passwordTokenRepository.save(myToken);
    }

    public String validatePasswordResetToken(String token) {
        PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
        if(isTokenFound(passToken)){
            if(isTokenExpired(passToken)) return "expiry";
            else return "valid";
        } else return "invalid";
    }
    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
}
