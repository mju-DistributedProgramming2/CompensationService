package com.example.compensationservice.DTO;

import com.example.compensationservice.Entity.Accident;
import com.example.compensationservice.enumeration.accident.AccidentStatus;

import java.sql.Timestamp;

public class ExamineCompensationRequest {
    private Accident accident;
    private int contractCompensation;
    private AccidentStatus status;

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public int getContractCompensation() {
        return contractCompensation;
    }

    public void setContractCompensation(int contractCompensation) {
        this.contractCompensation = contractCompensation;
    }

    public AccidentStatus getStatus() {
        return status;
    }

    public void setStatus(AccidentStatus status) {
        this.status = status;
    }
}
