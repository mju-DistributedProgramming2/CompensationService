package com.omnm.compensation.controller;



import com.omnm.compensation.DTO.ExamineCompensationRequest;
import com.omnm.compensation.DTO.ExamineCompensationResponse;
import com.omnm.compensation.DTO.GetCompensationRequest;
import com.omnm.compensation.DTO.GetCompensationResponse;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.exception.NoDataException;
import com.omnm.compensation.Service.CompensateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.RemoteException;

@RestController
public class CompensationController {
    @Autowired
    CompensateService compensateService;
    @GetMapping("/compensation")
    public GetCompensationResponse getCompensation(GetCompensationRequest getCompensationRequest) throws RemoteException, NoDataException {
        Compensation Compensation = compensateService.getCompensation(getCompensationRequest.getId());
        GetCompensationResponse getCompensationResponse = new GetCompensationResponse(Compensation);
        return getCompensationResponse;
    }
    @PostMapping("/compensation")
    public ExamineCompensationResponse examineCompensation(@RequestBody ExamineCompensationRequest examineCompensationRequest) throws RemoteException {
        boolean response = compensateService.examineCompensation(examineCompensationRequest.getAccident(),examineCompensationRequest.getContractCompensation(),examineCompensationRequest.getStatus());
        ExamineCompensationResponse examineCompensationResponse = new ExamineCompensationResponse(response);
        return examineCompensationResponse;
    }
}