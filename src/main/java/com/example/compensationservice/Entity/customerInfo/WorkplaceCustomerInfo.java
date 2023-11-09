package com.example.compensationservice.Entity.customerInfo;


import com.example.compensationservice.enumeration.calculationFormula.OutwallType;
import com.example.compensationservice.enumeration.calculationFormula.PillarType;
import com.example.compensationservice.enumeration.calculationFormula.RoofType;
import com.example.compensationservice.enumeration.calculationFormula.workplaceFormula.WorkplaceUsage;

public class WorkplaceCustomerInfo extends CustomerInfo {
    private WorkplaceUsage usage;
    private int floor;

    public WorkplaceCustomerInfo(String customerId, int squareMeter, PillarType pillarType, RoofType roofType, OutwallType outwallType, WorkplaceUsage usage, int floor) {
        super(customerId, squareMeter, pillarType, roofType, outwallType);
        this.usage = usage;
        this.floor = floor;
    }

    public WorkplaceUsage getUsage() {
        return usage;
    }

    public void setUsage(WorkplaceUsage usage) {
        this.usage = usage;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
