package com.teekee.waterdropservice.entity.dto.atm.atmCommChargeList;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 开始计费-DTO
 *
 * @author Wujun
 * @create 2017年09月14日 16:23
 */
public class StartChargeDTO {

    @NotBlank(message = "非法操作，请勿在此尝试")
    private String objectType;

    @Min(value = 1, message = "非法操作，请勿在此尝试")
    private int objectId;

    @NotNull(message = "非法操作，请勿在此尝试")
    private Date chargeStartDate;

    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public Date getChargeStartDate() {
        return chargeStartDate;
    }

    public void setChargeStartDate(Date chargeStartDate) {
        this.chargeStartDate = chargeStartDate;
    }

}
