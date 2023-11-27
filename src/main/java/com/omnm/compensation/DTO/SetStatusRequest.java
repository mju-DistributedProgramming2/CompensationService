package com.omnm.compensation.DTO;

import com.omnm.compensation.enumeration.accident.AccidentStatus;

public class SetStatusRequest {
    int accidentId;
    AccidentStatus status;

    public int getAccidentId() {return accidentId;}
    public void setAccidentId(int accidentId) {this.accidentId = accidentId;}
    public AccidentStatus getStatus() {return status;}
    public void setStatus(AccidentStatus status) {this.status = status;}
}
