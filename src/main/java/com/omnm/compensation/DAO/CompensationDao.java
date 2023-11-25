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
    public CompensationDao()   {
        super();
    }

    public boolean create(Compensation compensation) {
        if(compensationRepository.save(compensation)==null)return false;
        return true;
    }

    public List<Compensation> retrieve() {
        List<Compensation> compensationList = compensationRepository.findAll();
        return compensationList;
    }

    public int add(Compensation compensation) {
        List<Compensation> compensationList = retrieve();
        if(compensationList.size()==0)compensation.setId(1);
        else {compensation.setId(compensationList.get(compensationList.size()-1).getId()+1);}
        if(create(compensation)) return compensation.getId();
        else {return 0;}
    }

    public Compensation findByAccidentId(int id) {
        for(Compensation compensation : retrieve()){
            if(compensation.getAccidentId()==id) return compensation;
        }
        return null;
    }
}
