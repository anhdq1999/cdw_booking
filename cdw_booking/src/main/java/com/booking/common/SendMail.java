package com.booking.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMail {
    @Autowired
    private JavaMailSender mailSender;

}
