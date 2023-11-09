package com.example.compensationservice.service;



import com.example.compensationservice.Entity.Accident;
import com.example.compensationservice.Entity.Compensation;
import com.example.compensationservice.enumeration.accident.AccidentStatus;
import com.example.compensationservice.exception.NoDataException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompensateServiceIF  extends Remote {
    void setAccidentService(AccidentServiceIF accidentService) throws RemoteException;
    Compensation getCompensation(int id) throws RemoteException, NoDataException;
    boolean examineCompensation(Accident accident, int contractCompensation, AccidentStatus status) throws RemoteException;
}
