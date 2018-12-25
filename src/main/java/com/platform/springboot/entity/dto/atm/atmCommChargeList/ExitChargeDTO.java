package com.platform.springboot.entity.dto.atm.atmCommChargeList;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * 退出结算-DTO
 *
 * @author Wujun
 * @create 2017年09月18日 14:27
 */
public class ExitChargeDTO {


    @Min(value = 1, message = "非法操作，请勿再次尝试")
    private int objectId;

    @NotBlank(message = "非法操作，请勿再次尝试")
    private String objectType;

    private Date chargeExitDate;

    private String memo;

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Date getChargeExitDate() {
        return chargeExitDate;
    }

    public void setChargeExitDate(Date chargeExitDate) {
        this.chargeExitDate = chargeExitDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
