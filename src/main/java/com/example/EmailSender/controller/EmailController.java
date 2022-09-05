package com.example.EmailSender.controller;

import com.example.EmailSender.DTO.EmailMessage;
import com.example.EmailSender.service.impl.EmailSenderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage){
        EmailSenderServiceImpl.senderEmail(emailMessage.getToEmail(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("Success");
    }
}

