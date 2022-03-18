package com.csdisciple.backend.model;

import java.math.BigDecimal;

public class Facility {
    private BigDecimal id;
    private String name;
    private BigDecimal memberCost;
    private BigDecimal guestCost;
    private BigDecimal initialOutlay;
    private BigDecimal monthlyMaintenance;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMemberCost() {
        return memberCost;
    }

    public void setMemberCost(BigDecimal memberCost) {
        this.memberCost = memberCost;
    }

    public BigDecimal getGuestCost() {
        return guestCost;
    }

    public void setGuestCost(BigDecimal guestCost) {
        this.guestCost = guestCost;
    }

    public BigDecimal getInitialOutlay() {
        return initialOutlay;
    }

    public void setInitialOutlay(BigDecimal initialOutlay) {
        this.initialOutlay = initialOutlay;
    }

    public BigDecimal getMonthlyMaintenance() {
        return monthlyMaintenance;
    }

    public void setMonthlyMaintenance(BigDecimal monthlyMaintenance) {
        this.monthlyMaintenance = monthlyMaintenance;
    }

}
