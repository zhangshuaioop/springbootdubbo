package com.company.springboot.entity.dto.atm.atmCommChargeBillTempList;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 添加进入指定的临时账单-DTO
 *
 * @author Wujun
 * @create 2017年09月20日 10:53
 */
public class AddDTO extends BuildBillTempDTO {

    @NotBlank(message = "非法操作，请勿再次尝试！")
    private String tempBillNumber;

    public String getTempBillNumber() {
        return tempBillNumber;
    }

    public void setTempBillNumber(String tempBillNumber) {
        this.tempBillNumber = tempBillNumber;
    }
}
