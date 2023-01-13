package com.naijagis4me.v1.service.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naijagis4me.v1.controller.SkillTypeController;
import com.naijagis4me.v1.models.SkillType;
import com.naijagis4me.v1.service.SkillTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//import javax.lang.model.element.Name;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SkillTypeController.class)
class SkillTypeControllerMock {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SkillTypeService skillTypeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateSkillType(){


        try {
            SkillType skillTypeDto = new SkillType();
            skillTypeDto.setId(1L);
            skillTypeDto.setName("barber");
            skillTypeDto.setUpdatedAt(LocalDateTime.now());
            skillTypeDto.setCreatedAt(LocalDate.now());

            String requestBody = objectMapper.writeValueAsString(skillTypeDto);


            mockMvc.perform(put("/api/v1/skillType/update/{skillTypeId}")
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isOk());
        }catch (Exception ex){
            ex.printStackTrace();
        }


//        SkillTypeDto updatedSkillType = skillTypeRepository.findById(1L).get();
//        assertEquals("Updated Skill Type", updatedSkillType.getName());
    }
}

//   mockMvc.perform(MockMvcRequestBuilders
//           .put("/api/v1/skillType/update/{skillTypeId}", 1L)
//           .contentType(MediaType.APPLICATION_JSON)
//           .content(objectMapper.writeValueAsString(skillTypeDto)))
//           .andExpect(status().isOk());