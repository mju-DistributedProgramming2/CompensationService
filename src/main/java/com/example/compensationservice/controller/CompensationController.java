package com.example.compensationservice.controller;



import com.example.compensationservice.DTO.ExamineCompensationRequest;
import com.example.compensationservice.DTO.ExamineCompensationResponse;
import com.example.compensationservice.DTO.GetCompensationRequest;
import com.example.compensationservice.DTO.GetCompensationResponse;
import com.example.compensationservice.Entity.Accident;
import com.example.compensationservice.Entity.Compensation;
import com.example.compensationservice.exception.NoDataException;
import com.example.compensationservice.service.CompensateService;
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
        System.out.println(examineCompensationRequest.toString());
        Accident accident = new Accident(examineCompensationRequest.getContractId(),examineCompensationRequest.getDate(),examineCompensationRequest.getLocation(),examineCompensationRequest.getCause(),examineCompensationRequest.getContent(),examineCompensationRequest.getDamage(),examineCompensationRequest.getAccountNumber(),examineCompensationRequest.getStatus());
        boolean response = compensateService.examineCompensation(accident,examineCompensationRequest.getContractCompensation(),examineCompensationRequest.getStatus());
        ExamineCompensationResponse examineCompensationResponse = new ExamineCompensationResponse(response);
        return examineCompensationResponse;
    }
}