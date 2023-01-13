package com.naijagis4me.v1.service.serviceimpl;

import com.naijagis4me.v1.dtos.ProfileDto;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    Person person;
    Authentication authentication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        person = Person.builder()
                .firstName("Iyke")
                .lastName("Josh")
                .otherNames("Manny")
                .gender("Male")
                .email("iykejosh@email.com")
                .phoneNumber("09038393221")
                .build();

        authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    void viewProfile() {
            when(personRepository.findByEmail("iykejosh@email.com")).thenReturn(Optional.of(person));
            when(authentication.getName()).thenReturn("iykejosh@email.com");
            ProfileDto dto = personService.viewProfile();

            verify(personRepository).findByEmail("iykejosh@email.com");

            assertEquals("Iyke", dto.getFirstName());
            assertEquals("Josh", dto.getLastName());
            assertEquals("Manny", dto.getOtherNames());
            assertEquals("Male", dto.getGender());
            assertEquals("iykejosh@email.com", dto.getEmail());
            assertEquals("09038393221", dto.getPhoneNumber());
        }
}