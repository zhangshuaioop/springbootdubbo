package com.company.springboot.entity.atm;

import java.math.BigDecimal;

public class AtmCommChargeBillTempList {
    private Integer id;

    private String tempBillNumber;

    private Integer chargeListId;

    private BigDecimal actualFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempBillNumber() {
        return tempBillNumber;
    }

    public void setTempBillNumber(String tempBillNumber) {
        this.tempBillNumber = tempBillNumber == null ? null : tempBillNumber.trim();
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