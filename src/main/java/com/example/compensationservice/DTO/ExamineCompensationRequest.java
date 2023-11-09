package com.example.compensationservice.DTO;

import com.example.compensationservice.Entity.Accident;
import com.example.compensationservice.enumeration.accident.AccidentStatus;

import java.sql.Timestamp;

public class ExamineCompensationRequest {
    private int id;
    private int contractId;
    private Timestamp date;
    private String location;
    private String cause;
    private String content;
    private long damage;
    private String accountNumber;
    private AccidentStatus accidentStatus;
    private int contractCompensation;
    private AccidentStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccidentStatus getAccidentStatus() {
        return accidentStatus;
    }

    public void setAccidentStatus(AccidentStatus accidentStatus) {
        this.accidentStatus = accidentStatus;
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

    @Override
    public String toString() {
        return "ExamineCompensationRequest{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", cause='" + cause + '\'' +
                ", content='" + content + '\'' +
                ", damage=" + damage +
                ", accountNumber='" + accountNumber + '\'' +
                ", accidentStatus=" + accidentStatus +
                ", contractCompensation=" + contractCompensation +
                ", status=" + status +
                '}';
    }
}
