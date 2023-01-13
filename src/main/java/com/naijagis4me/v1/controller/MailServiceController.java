package com.naijagis4me.v1.controller;


import com.naijagis4me.v1.dtos.SendEmailRequestDto;
import com.naijagis4me.v1.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
//@RequiredArgsConstructor
public class MailServiceController {

    @Autowired
    private EmailSenderService emailService;

    @PostMapping("/send")
    public void sendEmail(@RequestBody @Valid SendEmailRequestDto request){
        emailService.sendEmail(request);

    }
}
