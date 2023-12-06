package com.omnm.compensation.DTO;

import com.omnm.compensation.Entity.Accident;
import com.omnm.compensation.enumeration.accident.AccidentStatus;

public class PostCompensationRequest {
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