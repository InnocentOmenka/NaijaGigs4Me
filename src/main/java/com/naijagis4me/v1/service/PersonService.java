package com.naijagis4me.v1.service;

import com.naijagis4me.v1.dtos.ProfileDto;
import com.naijagis4me.v1.models.Person;
import org.springframework.http.ResponseEntity;

public interface PersonService {
    ProfileDto viewProfile();
}
