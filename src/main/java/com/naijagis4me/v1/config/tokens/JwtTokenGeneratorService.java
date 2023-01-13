package com.naijagis4me.v1.config.tokens;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenGeneratorService {
    String generateToken(UserDetails user);
    String generateTokenWithAuthentication(Authentication authentication);
}
