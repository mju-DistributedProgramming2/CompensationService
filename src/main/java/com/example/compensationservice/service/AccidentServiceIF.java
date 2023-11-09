package com.example.compensationservice.service;



import com.example.compensationservice.Entity.Accident;
import com.example.compensationservice.enumeration.accident.AccidentStatus;
import com.example.compensationservice.exception.EmptyListException;
import com.example.compensationservice.exception.NoDataException;
import com.example.compensationservice.exception.TimeDelayException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AccidentServiceIF  extends Remote{
    ArrayList<Accident> getAccidentList(AccidentStatus status) throws RemoteException, EmptyListException, TimeDelayException;

    ArrayList<Accident> getAccidentList() throws RemoteException, EmptyListException, TimeDelayException;

    Accident getAccident(int id) throws RemoteException, NoDataException;

    int reportAccident(Accident accident) throws RemoteException;

    boolean setStatus(int accidentId, AccidentStatus status) throws RemoteException;
}
