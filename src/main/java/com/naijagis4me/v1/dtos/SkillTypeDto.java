package com.naijagis4me.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.*;


import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillTypeDto {
    @NotBlank(message = "Please enter a skill type")
    private String name;
}
