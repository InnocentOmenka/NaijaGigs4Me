package com.naijagis4me.v1.controller;

import com.naijagis4me.v1.config.userDetails.AppUserDetailsService;
import com.naijagis4me.v1.dtos.LoginDto;
import com.naijagis4me.v1.dtos.ProfileDto;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.response.ApiResponse;
import com.naijagis4me.v1.config.tokens.JwtTokenGeneratorService;
import com.naijagis4me.v1.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService userDetailsService;
    private final JwtTokenGeneratorService tokenService;
    private final PersonService personService;


    @PostMapping("login")
    public ApiResponse<String> login(@Valid @RequestBody LoginDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        System.out.println("AUTHENTICATION: " + authentication);
        UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        if (user != null)
            return new ApiResponse<>("Login Successful!", HttpStatus.OK,
                    tokenService.generateToken(user));
        return new ApiResponse<>("Login Failed", HttpStatus.BAD_REQUEST, "Some Error Occurred!");
    }
}
