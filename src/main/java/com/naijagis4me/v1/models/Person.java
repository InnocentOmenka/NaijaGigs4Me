package com.naijagis4me.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naijagis4me.v1.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "persons")
public class Person extends Base {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String otherNames;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @UpdateTimestamp
    private LocalDateTime lastLogin;

    private String dob;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column(nullable = false)
    private boolean verificationStatus;

    private boolean verified;
}
