package com.teekee.waterdropservice.entity.dto.atm.atmCommChargeList;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

/**
 * 完成退出结算-DTO
 *
 * @author Wujun
 * @create 2017年09月19日 11:04
 */
public class FinishExitChargeDTO {
    @NotBlank(message = "非法操作，请勿在此尝试")
    private String objectType;

    @Min(value = 1, message = "非法操作，请勿在此尝试")
    private int objectId;

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
}
