package com.teekee.waterdropservice.entity.dto.atm.atmCommChargeBillTempList;

import java.math.BigDecimal;
import java.util.List;

/**
 * 临时合并计费-DTO
 *
 * @author Wujun
 * @create 2017年09月19日 13:52
 */
public class BuildBillTempDTO {
    private List<Integer> idList;

    private List<BigDecimal> feeList;

    private String tempBillNumber;

    public String getTempBillNumber() {
        return tempBillNumber;
    }

    public void setTempBillNumber(String tempBillNumber) {
        this.tempBillNumber = tempBillNumber;
    }

    public List<BigDecimal> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<BigDecimal> feeList) {
        this.feeList = feeList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
