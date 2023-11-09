package com.example.compensationservice.service;




import com.example.compensationservice.Entity.Accident;
import com.example.compensationservice.Entity.Compensation;
import com.example.compensationservice.dao.CompensationDao;
import com.example.compensationservice.enumeration.accident.AccidentStatus;
import com.example.compensationservice.exception.NoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
public class CompensateService extends UnicastRemoteObject implements CompensateServiceIF {
    @Autowired
    CompensationDao compensationDao;
    private AccidentServiceIF accidentService;

    protected CompensateService() throws RemoteException {
    }

    @Override
    public void setAccidentService(AccidentServiceIF accidentService)throws RemoteException{
        this.accidentService = accidentService;
    }
    @Override
    public Compensation getCompensation(int id) throws RemoteException, NoDataException {
        Compensation compensation = compensationDao.findByAccidentId(id);
        if(compensation == null) throw new NoDataException("보상내역이 존재하지 않습니다.");
        return compensation;
    }
    @Override
    public boolean examineCompensation(Accident accident, int contractCompensation, AccidentStatus status) throws RemoteException{
        if(status== AccidentStatus.Compensate){
            boolean isSuccess = accidentService.setStatus(accident.getId(), status);
            if(!isSuccess) return false;
            int compensation = 0;
            if(contractCompensation>=accident.getDamage()) compensation = (int) accident.getDamage();
            if(contractCompensation<accident.getDamage()) compensation = contractCompensation;
            int id = compensationDao.add(new Compensation(accident.getId(), compensation));
            if(id!=0) return true;
            else return false;
        }else{
            return accidentService.setStatus(accident.getId(), status);
        }
    }
}
