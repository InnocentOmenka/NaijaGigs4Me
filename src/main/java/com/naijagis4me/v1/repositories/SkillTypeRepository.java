package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.dtos.SkillTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillTypeDto, Long> {
}
