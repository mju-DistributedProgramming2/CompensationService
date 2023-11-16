package com.example.compensationservice.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Compensation implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "accident_id",nullable = false)
    private int accidentId;
    @Column(name = "compensation",nullable = false)
    private int compensation;
    public Compensation(int accidentId, int compensation) {
        this.accidentId = accidentId;
        this.compensation = compensation;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(int accidentId) {
        this.accidentId = accidentId;
    }

    public int getCompensation() {
        return compensation;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    public Compensation() {

    }

}
