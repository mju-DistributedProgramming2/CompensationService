package com.omnm.compensation.Repository;

import com.omnm.compensation.Entity.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompensationRepository extends JpaRepository<Compensation,Integer> {
    Compensation findByAccidentId(int Accidentid);
}
