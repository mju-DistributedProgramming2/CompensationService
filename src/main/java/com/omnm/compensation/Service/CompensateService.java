package com.omnm.compensation.Service;




import com.omnm.compensation.DTO.SetStatusRequest;
import com.omnm.compensation.DTO.SetStatusResponse;
import com.omnm.compensation.Entity.Accident;
import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.configuration.Constants;
import com.omnm.compensation.configuration.PatchRestTemplate;
import com.omnm.compensation.DAO.CompensationDao;
import com.omnm.compensation.enumeration.accident.AccidentStatus;
import com.omnm.compensation.exception.NoDataException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
@EnableDiscoveryClient
public class CompensateService extends UnicastRemoteObject implements CompensateServiceIF {
    @Autowired
    CompensationDao compensationDao;

    @Autowired
    ObjectMapper objectMapper;

    protected CompensateService() throws RemoteException {
    }

    @Override
    public Compensation getCompensation(int id) throws RemoteException, NoDataException {
        Compensation compensation = compensationDao.findByAccidentId(id);
        if(compensation == null) throw new NoDataException("보상내역이 존재하지 않습니다.");
        return compensation;
    }
    @Override
    public boolean examineCompensation(Accident accident, int contractCompensation, AccidentStatus status) throws RemoteException {
        if (status == AccidentStatus.Compensate) {
            boolean isSuccess = getCustomerInCustomerService(accident.getId(), status);
            if (!isSuccess) return false;
            int compensation = 0;
            if (contractCompensation >= accident.getDamage()) compensation = (int) accident.getDamage();
            if (contractCompensation < accident.getDamage()) compensation = contractCompensation;
            int id = compensationDao.add(new Compensation(accident.getId(), compensation));
            if (id != 0) return true;
            else return false;
        } else{
            return getCustomerInCustomerService(accident.getId(), status);
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
        ResponseEntity<SetStatusResponse> result = template.exchange(uri, HttpMethod.PATCH, requestEntity, SetStatusResponse.class);
        return result.getBody().isStatusResponse();
    }
}
