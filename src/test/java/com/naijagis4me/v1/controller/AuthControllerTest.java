package com.naijagis4me.v1.controller;

import com.naijagis4me.v1.config.SecurityConfig;
import com.naijagis4me.v1.config.userDetails.AppUserDetails;
import com.naijagis4me.v1.config.userDetails.AppUserDetailsService;
import com.naijagis4me.v1.dtos.LoginDto;
import com.naijagis4me.v1.enums.Roles;
import com.naijagis4me.v1.models.Address;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import com.naijagis4me.v1.response.ApiResponse;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    AuthController authController;

    @MockBean
    SecurityConfig securityConfig;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    PersonRepository personRepository;

    @MockBean
    Authentication authentication;

    @MockBean
    AuthenticationManager authenticationManager;

    @MockBean
    AppUserDetailsService userDetailsService;

    private Person person;
    private LoginDto loginDto;
    private Address address;

    @BeforeEach
    void setUp() {
        person = Person.builder()
                .firstName("Orlando")
                .lastName("Bloom")
                .otherNames("Henry")
                .gender("MALE")
                .email("orlando@gmail.com")
                .phoneNumber("081087584747")
                .password(passwordEncoder.encode("password123"))
                .dob("12-05-1998")
                .role(Roles.SUPERADMIN)
                .verificationStatus(true)
                .verified(true)
                .build();

        person.setId(23L);

        address = Address.builder()
                .person(person)
                .country("Australia")
                .state("Adelaide")
                .homeAddress("24th Avenue, Courtney Street")
                .build();

        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);

        loginDto = new LoginDto("orlando@gmail.com",
                passwordEncoder.encode("password123"));

        personRepository.save(person);

    }


    @Test
    void whenLoginThenReturnLoginSuccessfulAndOk() {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        when(personRepository.save(person)).thenReturn(person);

        when(authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                       email, password)))
                .thenReturn(null);

        UserDetails userDetails = new AppUserDetails(person);

        when(userDetailsService.loadUserByUsername(email))
                .thenReturn(userDetails);

        ApiResponse<String> apiResponse =
                authController.login(loginDto);

        assertEquals("Login Successful!", apiResponse.getMessage());
        assertNotNull(apiResponse.getPayload());
    }

    @Test
    void whenLoginThenReturnLoginFailedAnd400() {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        when(personRepository.save(person)).thenReturn(person);

        when(authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        email, password)))
                .thenReturn(null);

        when(userDetailsService.loadUserByUsername(email))
                .thenReturn(null);

        ApiResponse<String> apiResponse =
                authController.login(loginDto);

        assertEquals("Login Failed", apiResponse.getMessage());
        assertEquals("Some Error Occurred!", apiResponse.getPayload());
    }

    @Test
    void testAuthenticationManager() {

        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        when(personRepository.save(person)).thenReturn(person);

        when(authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        email, password)))
                .thenReturn(authentication);

        ApiResponse<String> apiResponse = authController.login(loginDto);
        assertNotNull(apiResponse.getPayload());
    }
}