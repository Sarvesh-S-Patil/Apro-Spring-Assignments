package com.apro.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.service.EmailService;

@RestController
@RequestMapping("/email-app")
public class EmailController {

    @Autowired
    private EmailService mailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String subject, @RequestBody String content, @RequestParam String senderEmail) {
        mailService.sendSimpleMessage(subject, content, senderEmail);
        return "Email sent successfully";
    }
}
