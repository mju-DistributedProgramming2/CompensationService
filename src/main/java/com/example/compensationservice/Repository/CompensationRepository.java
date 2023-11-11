package com.example.compensationservice.Repository;

import com.example.compensationservice.Entity.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompensationRepository extends JpaRepository<Compensation,Integer> {
    Compensation findByAccidentId(int Accidentid);
}
