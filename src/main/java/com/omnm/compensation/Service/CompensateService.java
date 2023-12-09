package com.omnm.compensation.Service;




import com.omnm.compensation.DTO.SetStatusRequest;
import com.omnm.compensation.Entity.Accident;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.configuration.Constants;
import com.omnm.compensation.configuration.PatchRestTemplate;
import com.omnm.compensation.DAO.CompensationDao;
import com.omnm.compensation.enumeration.accident.AccidentStatus;
import com.omnm.compensation.exception.NoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
@EnableDiscoveryClient
public class CompensateService implements CompensateServiceIF {
    @Autowired
    CompensationDao compensationDao;

    @Override
    public ResponseEntity<Compensation> getCompensationByAccidentId(int id){
        Compensation compensation = compensationDao.findCompensationByAccidentId(id);
        try {
            if(compensation == null) new NoDataException("");
        }catch (Exception e){
            return new ResponseEntity<>(null,new HttpHeaders(),HttpStatus.valueOf(500));
        }
        return new ResponseEntity<>(compensation,new HttpHeaders(),HttpStatus.valueOf(200));
    }
    @Override
    public ResponseEntity<Boolean> postCompensation(Accident accident, int contractCompensation, AccidentStatus status) {
        if (status == AccidentStatus.Compensate) {boolean isSuccess = getCustomerInCustomerService(accident.getId(), status);
            if (!isSuccess) return new ResponseEntity<>(false,new HttpHeaders(),HttpStatus.valueOf(200));
            int compensation = 0;
            if (contractCompensation >= accident.getDamage()) compensation = (int) accident.getDamage();
            if (contractCompensation < accident.getDamage()) compensation = contractCompensation;
            int id = compensationDao.createCompensation(new Compensation(accident.getId(), compensation));
            Boolean successFlag = false;
            if (id != 0) successFlag =  true;
            return new ResponseEntity<>(successFlag,new HttpHeaders(),HttpStatus.valueOf(200));
        } else{
            return new ResponseEntity<>(getCustomerInCustomerService(accident.getId(), status),new HttpHeaders(),HttpStatus.valueOf(200));
        }
    }
    public boolean getCustomerInCustomerService(int accidentId, AccidentStatus status) {
        PatchRestTemplate template = new PatchRestTemplate();
        URI uri = UriComponentsBuilder
                .fromUriString(Constants.BASE_URL)
                .path(Constants.ACCIDENT_SERVICE_GET_ACCIDENT_URL + "status")
                .encode()
                .build()
                .toUri();

        SetStatusRequest setStatusRequest = new SetStatusRequest();
        setStatusRequest.setAccidentId(accidentId);
        setStatusRequest.setStatus(status);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity = new HttpEntity(setStatusRequest, headers);
        try {
            ResponseEntity<Boolean> result = template.exchange(uri, HttpMethod.PATCH, requestEntity, Boolean.class);
            return result.getBody().booleanValue();
        }catch (Exception e) {return false;}
    }
}
