package com.platform.springboot.entity.dto.atm.atmCommChargeBill;

/**
 * 调整账单-DTO
 *
 * @author Wujun
 * @create 2017年09月21日 16:27
 */
public class AdjustBuillDTO extends BuildBillDTO {
    private int chargeBillId;

    public int getChargeBillId() {
        return chargeBillId;
    }

    public void setChargeBillId(int chargeBillId) {
        this.chargeBillId = chargeBillId;
    }
}
