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

    public int getId() {return id;}

    public int getAccidentId() {return accidentId;}

    public int getCompensation() {return compensation;}

    @Override
    public String toString() {
        return "GetCompensationResponse{" +
                "id=" + id +
                ", accidentId=" + accidentId +
                ", compensation=" + compensation +
                '}';
    }
}
