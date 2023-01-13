package com.naijagis4me.v1;

import com.naijagis4me.v1.config.jwt.RSAKeyProperties;
import com.naijagis4me.v1.dtos.SendEmailRequestDto;
import com.naijagis4me.v1.enums.Roles;
import com.naijagis4me.v1.models.Address;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import com.naijagis4me.v1.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@EnableConfigurationProperties(RSAKeyProperties.class)
@SpringBootApplication
public class Naijagigs4meV1Application {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Naijagigs4meV1Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {

			Person person = Person.builder()
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

			Address address1 = Address.builder()
					.person(person)
					.country("Australia")
					.state("Adelaide")
					.homeAddress("24th Avenue, Courtney Street")
					.build();

			Set<Address> addressSet = new HashSet<>();
			addressSet.add(address1);

			personRepository.save(person);
		};
	}


}
