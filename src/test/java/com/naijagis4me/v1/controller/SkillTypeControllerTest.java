package com.naijagis4me.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naijagis4me.v1.dtos.SkillTypeDto;
import com.naijagis4me.v1.service.SkillTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SkillTypeController.class)
@AutoConfigureMockMvc(addFilters = false)
class SkillTypeControllerTest {

    @MockBean
    private SkillTypeService skillTypeService;

    private MockMvc mockMvc;

    @MockBean
    ObjectMapper objectMapper;


    @Test
    void updateSkillType() throws Exception {

        Long skillTypeId = 1L;
        SkillTypeDto skillTypeDto = new SkillTypeDto();
        skillTypeDto.setName("barbing");
        given(skillTypeService.updateSkillType(skillTypeDto, skillTypeId)).willReturn(skillTypeDto);

        String requestBody = objectMapper.writeValueAsString(skillTypeDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/skilltype/update/{skillTypeId}", skillTypeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());


    }


}