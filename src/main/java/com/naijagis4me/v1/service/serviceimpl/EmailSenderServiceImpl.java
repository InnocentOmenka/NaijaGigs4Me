package com.naijagis4me.v1.service.serviceimpl;

import com.naijagis4me.v1.dtos.SendEmailRequestDto;
import com.naijagis4me.v1.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender mailSender;
    @Override
    public void sendEmail(SendEmailRequestDto request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("naijagigs4me5@gmail.com");
        simpleMailMessage.setTo(request.getReceiver());
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setText(request.getBody());
        simpleMailMessage.setSentDate(new Date());

        try{
            mailSender.send(simpleMailMessage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
