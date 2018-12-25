package com.platform.springboot.entity.ret.atm.atmCommChargeList;

import java.math.BigDecimal;

/**
 * 收费汇总-返回结果
 *
 * @author Wujun
 * @create 2017年09月18日 11:29
 */
public class ChargeCollectRet {

    /**
     * 总账期
     */
    private int accountTotal;

    /**
     * 应收账期
     */
    private int expectedAccount;

    /**
     * 实收账期
     */
    private int actualAccount;

    /**
     * 实收费用
     */
    private BigDecimal actualChargeFee;

    public int getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(int accountTotal) {
        this.accountTotal = accountTotal;
    }

    public int getExpectedAccount() {
        return expectedAccount;
    }

    public void setExpectedAccount(int expectedAccount) {
        this.expectedAccount = expectedAccount;
    }

    public int getActualAccount() {
        return actualAccount;
    }

    public void setActualAccount(int actualAccount) {
        this.actualAccount = actualAccount;
    }

    public BigDecimal getActualChargeFee() {
        return actualChargeFee;
    }

    public void setActualChargeFee(BigDecimal actualChargeFee) {
        this.actualChargeFee = actualChargeFee;
    }
}
