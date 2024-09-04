package com.apro.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(String subject, String content,String sendToEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendToEmail);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }
}
