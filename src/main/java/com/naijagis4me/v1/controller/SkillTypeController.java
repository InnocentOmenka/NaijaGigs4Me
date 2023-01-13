package com.naijagis4me.v1.controller;

import com.naijagis4me.v1.dtos.SkillTypeDto;
import com.naijagis4me.v1.service.SkillTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/skillType/")
public class SkillTypeController {

    private final SkillTypeService skillTypeService;

    @PutMapping("/update/{skillTypeId}")
    public ResponseEntity<SkillTypeDto> updateSkillType(@Valid @RequestBody SkillTypeDto skillTypeRequestDto,
                                                        @PathVariable(name = "skillTypeId") Long skillTypeId ){
        SkillTypeDto skillTypeDto = skillTypeService.updateSkillType(skillTypeRequestDto, skillTypeId);
        return new ResponseEntity<>(skillTypeDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete_expense/{id}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable Long id){
        return new ResponseEntity<>( skillTypeService.deleteSkillType(id), HttpStatus.OK);
    }
}
