package com.naijagis4me.v1.service.serviceimpl;

import com.naijagis4me.v1.dtos.SkillTypeDto;
import com.naijagis4me.v1.exceptions.ResourceNotFoundException;
import com.naijagis4me.v1.repositories.SkillTypeRepository;
import com.naijagis4me.v1.service.SkillTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillTypeServiceImpl implements SkillTypeService {

    private final SkillTypeRepository skillTypeRepository;


    @Override
    public SkillTypeDto updateSkillType(SkillTypeDto skillTypeDto, Long skillTypeId) {

        SkillTypeDto existingSkillType = skillTypeRepository.findById(skillTypeId).orElseThrow(()->
                new ResourceNotFoundException("SkillType not found", HttpStatus.NOT_FOUND, "Please select a skilltype" ));
                existingSkillType.setName(skillTypeDto.getName());
                return skillTypeRepository.save(existingSkillType);

    }

    @Override
    public Boolean deleteSkillType(Long id) {
                 SkillTypeDto skillType=skillTypeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("SkillType not found", HttpStatus.BAD_REQUEST,"Please select a skilltype"));
                skillTypeRepository.delete(skillType);
                return true;
    }
}
