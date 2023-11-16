package com.example.compensationservice.dao;



import com.example.compensationservice.Entity.Compensation;
import com.example.compensationservice.Repository.CompensationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompensationDao extends Dao {
    @Autowired
    CompensationRepository compensationRepository;
    public CompensationDao()   {
        super();
    }

    public boolean create(Compensation compensation) {
//        String query ="insert into compensation values ("+
//                compensation.getId()+", "+
//                compensation.getAccidentId()+", "+
//                compensation.getCompensation()+");";
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println(compensation.getAccidentId());
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        compensationRepository.save(compensation);
        if(compensationRepository.save(compensation)==null)return false;
        return true;
    }

    public List<Compensation> retrieve() {
        List<Compensation> compensationList = compensationRepository.findAll();
//        String query = "select * from compensation;";
//        resultSet = this.retrieve(query);
//        try {
//            while(resultSet.next()) {
//                Compensation compensation = new Compensation(resultSet.getInt(2), resultSet.getInt(3));
//                compensation.setId(resultSet.getInt(1));
//                compensationList.add(compensation);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
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
            System.out.println(compensation.getAccidentId());
            if(compensation.getAccidentId()==id) return compensation;
        }
        return null;
    }
}
