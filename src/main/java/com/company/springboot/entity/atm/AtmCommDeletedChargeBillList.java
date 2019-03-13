package com.company.springboot.entity.atm;

import java.math.BigDecimal;

public class AtmCommDeletedChargeBillList {
    private Integer id;

    private String billId;

    private Integer chargeListId;

    private BigDecimal actualFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public Integer getChargeListId() {
        return chargeListId;
    }

    public void setChargeListId(Integer chargeListId) {
        this.chargeListId = chargeListId;
    }

    public BigDecimal getActualFee() {
        return actualFee;
    }

    public void setActualFee(BigDecimal actualFee) {
        this.actualFee = actualFee;
    }
}