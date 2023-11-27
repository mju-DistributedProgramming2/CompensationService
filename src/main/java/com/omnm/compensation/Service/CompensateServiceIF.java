package com.omnm.compensation.Service;



import com.omnm.compensation.Entity.Accident;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.enumeration.accident.AccidentStatus;
import com.omnm.compensation.exception.NoDataException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompensateServiceIF  extends Remote {
    Compensation getCompensation(int id) throws RemoteException, NoDataException;
    boolean examineCompensation(Accident accident, int contractCompensation, AccidentStatus status) throws RemoteException;
}
