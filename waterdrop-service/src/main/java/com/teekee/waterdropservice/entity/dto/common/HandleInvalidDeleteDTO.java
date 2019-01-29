package com.teekee.waterdropservice.entity.dto.common;

import javax.validation.constraints.Min;

/**
 * 失效服务商联系人
 *
 * @author Wujun
 * @create 2017年09月07日 16:23
 */
public class HandleInvalidDeleteDTO {

    @Min(value = 1, message = "非法操作，请勿再次尝试")
    private int id;

    private boolean flagDelete;

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
