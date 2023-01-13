package com.naijagis4me.v1.dtos;

import com.naijagis4me.v1.enums.Roles;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Builder
@Data
public class ProfileDto {

    private String firstName;

    private String lastName;

    private String otherNames;

    private String gender;

    private String email;

    private String phoneNumber;

    private String dob;

    private boolean verified;
}
