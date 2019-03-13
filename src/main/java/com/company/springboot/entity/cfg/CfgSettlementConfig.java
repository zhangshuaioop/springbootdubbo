package com.company.springboot.entity.cfg;

public class CfgSettlementConfig {
    private Integer id;

    private Integer payFrequency;

    private Integer settlementType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(Integer payFrequency) {
        this.payFrequency = payFrequency;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }
}