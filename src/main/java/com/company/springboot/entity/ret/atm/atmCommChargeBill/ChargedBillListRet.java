package com.company.springboot.entity.ret.atm.atmCommChargeBill;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询待出票收费账单列表-返回结果
 *
 * @author Wujun
 * @create 2017年09月22日 18:06
 */
public class ChargedBillListRet extends NoInvoiceListRet {

    private String closedPerson;

    private Date closedTime;

    private BigDecimal chargeFee;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getClosedPerson() {
        return closedPerson;
    }

    public void setClosedPerson(String closedPerson) {
        this.closedPerson = closedPerson;
    }

    public Date getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }

    public BigDecimal getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(BigDecimal chargeFee) {
        this.chargeFee = chargeFee;
    }
}
