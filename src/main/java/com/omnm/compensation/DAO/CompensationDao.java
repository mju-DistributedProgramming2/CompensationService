package com.omnm.compensation.DAO;



import com.omnm.compensation.Entity.Compensation;
import com.omnm.compensation.Repository.CompensationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CompensationDao{
    @Autowired
    CompensationRepository compensationRepository;

    public int createCompensation(Compensation compensation) {
        return compensationRepository.save(compensation).getId();
    }

    public Compensation findCompensationByAccidentId(int id) {
        System.out.println(compensationRepository.findByAccidentId(id));
        try {return compensationRepository.findByAccidentId(id);}
        catch (Exception e) {return null;}
    }
}
