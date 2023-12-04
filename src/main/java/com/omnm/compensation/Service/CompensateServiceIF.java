package com.omnm.compensation.Service;



import com.omnm.compensation.Entity.Accident;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.enumeration.accident.AccidentStatus;
import com.omnm.compensation.exception.NoDataException;
import org.springframework.http.ResponseEntity;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompensateServiceIF  extends Remote {
    ResponseEntity<Compensation> getCompensationByAccidentId(int id) throws RemoteException, NoDataException;
    ResponseEntity<Boolean> postCompensation(Accident accident, int contractCompensation, AccidentStatus status) throws RemoteException;
}
