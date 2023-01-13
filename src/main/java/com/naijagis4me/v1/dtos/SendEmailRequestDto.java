package com.naijagis4me.v1.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SendEmailRequestDto {

    @Email(message = "Enter a valid email address")
    private String receiver;
    private String subject;
    private String body;
}
