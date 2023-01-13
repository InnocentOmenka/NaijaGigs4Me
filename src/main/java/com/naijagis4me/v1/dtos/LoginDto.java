package com.naijagis4me.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @Email
    @NotNull(message = "Email is a required field")
    private String email;

    @NotNull(message = "Password is a required field")
    @Size(min = 8, max=25, message="Password must be equal to or " +
            "greater than 8 character and less than 25 characters")
    private String password;

}
