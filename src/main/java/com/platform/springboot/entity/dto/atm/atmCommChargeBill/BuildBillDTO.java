package com.platform.springboot.entity.dto.atm.atmCommChargeBill;

import com.platform.springboot.entity.atm.AtmCommChargeBill;
import com.platform.springboot.entity.atm.AtmCommChargeBill;

import java.math.BigDecimal;
import java.util.List;

/**
 * 生成账单-DTO
 *
 * @author Wujun
 * @create 2017年09月20日 18:33
 */
public class BuildBillDTO extends AtmCommChargeBill {
    private List<Integer> chargeListIdList;

    private List<BigDecimal> feeList;

    private int billId;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public List<Integer> getChargeListIdList() {
        return chargeListIdList;
    }

    public void setChargeListIdList(List<Integer> chargeListIdList) {
        this.chargeListIdList = chargeListIdList;
    }

    public List<BigDecimal> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<BigDecimal> feeList) {
        this.feeList = feeList;
    }
}
