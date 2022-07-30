package com.booking.services.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {


    private JavaMailSender javaMailSender;

//    @Value("${spring.mail.username}")
//    private String sender;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        return null;
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return null;
    }
}
