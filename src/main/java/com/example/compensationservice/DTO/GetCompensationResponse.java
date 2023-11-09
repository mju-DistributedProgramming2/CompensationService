package com.example.compensationservice.DTO;

import com.example.compensationservice.Entity.Compensation;

public class GetCompensationResponse {
    private int id;
    private int accidentId;
    private int compensation;
    public GetCompensationResponse(Compensation compensation) {
        this.id = compensation.getId();
        this.accidentId = compensation.getAccidentId();
        this.compensation = compensation.getCompensation();
    }
}
