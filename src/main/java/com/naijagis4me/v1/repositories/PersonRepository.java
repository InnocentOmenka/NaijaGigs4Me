package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String username);

    Optional<Person> findByEmailAndPassword(String email, String password);
}
