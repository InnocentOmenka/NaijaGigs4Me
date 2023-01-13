package com.naijagis4me.v1.service;

import com.naijagis4me.v1.dtos.SkillTypeDto;


public interface SkillTypeService {
    public SkillTypeDto updateSkillType(SkillTypeDto skillTypeDto, Long skillTypeId);
    public Boolean deleteSkillType(Long id);
}
