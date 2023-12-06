package com.omnm.compensation.Controller;



import com.omnm.compensation.DTO.PostCompensationRequest;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.Service.CompensateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    @Autowired
    CompensateService compensateService;
    @GetMapping("/compensation/{accidentid}")
    public ResponseEntity<Compensation> getCompensationByAccidentId(@PathVariable("accidentid") int id){
        return compensateService.getCompensationByAccidentId(id);
    }
    @PostMapping("/compensation")
    public ResponseEntity<Boolean> postCompensation(@RequestBody PostCompensationRequest postCompensationRequest){
        return compensateService.postCompensation(postCompensationRequest.getAccident(), postCompensationRequest.getContractCompensation(), postCompensationRequest.getStatus());
    }
}