package com.omnm.compensation.Controller;



import com.omnm.compensation.DTO.ExamineCompensationRequest;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.Service.CompensateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    @Autowired
    CompensateService compensateService;
    @GetMapping("/compensation")
    public ResponseEntity<Compensation> getCompensation(@Param("id") int id){
        return compensateService.getCompensation(id);
    }
    @PostMapping("/compensation")
    public ResponseEntity<Boolean> postCompensation(@RequestBody ExamineCompensationRequest examineCompensationRequest){
        return compensateService.postCompensation(examineCompensationRequest.getAccident(),examineCompensationRequest.getContractCompensation(),examineCompensationRequest.getStatus());
    }
}