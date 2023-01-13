package com.naijagis4me.v1.controller;

import com.naijagis4me.v1.dtos.ProfileDto;
import com.naijagis4me.v1.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final PersonService personService;

    @GetMapping("/profile")
    public ResponseEntity<ProfileDto> viewProfile(){
        ProfileDto profileDto = personService.viewProfile();
        return new ResponseEntity<>(profileDto, HttpStatus.OK);
    }
}
