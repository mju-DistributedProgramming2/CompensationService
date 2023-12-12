package com.omnm.compensation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnm.compensation.DTO.PostCompensationRequest;
import com.omnm.compensation.Entity.Accident;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.Service.CompensateService;
import com.omnm.compensation.enumeration.accident.AccidentStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CompensationServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompensateService compensateService;

    @Test
    void testGetCompensationByAccidentId() throws Exception {
        Compensation compensation = new Compensation();
        when(compensateService.getCompensationByAccidentId(1)).thenReturn(ResponseEntity.ok(compensation));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/compensation/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(compensateService, times(1)).getCompensationByAccidentId(1);
    }

    @Test
    void testPostCompensation() throws Exception {
        // 테스트에서 사용할 데이터 생성
        Accident accident = new Accident();
        int contractCompensation = 1;
        AccidentStatus status = AccidentStatus.RefuseCompensate;
        PostCompensationRequest postCompensationRequest = new PostCompensationRequest(accident, contractCompensation, status);

        // postCompensation 메서드가 호출될 때 ResponseEntity.ok(true)를 반환하도록 설정
        when(compensateService.postCompensation(accident, contractCompensation, status)).thenReturn(ResponseEntity.ok(true));

        // POST 요청 수행
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/compensation")
                        .content(objectMapper.writeValueAsString(postCompensationRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 테스트에서 예상하는 동작에 따라 검증
        // postCompensation 메서드가 특정 인자로 호출되었는지 검증
        verify(compensateService).postCompensation(any(), eq(contractCompensation), eq(status));
    }
}
