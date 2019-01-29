package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;

/**
 * @Author Niting
 * @date 2018/7/19
 **/
public class GetDispatchOrderServiceStatusList extends BaseEntity{
    private String status;
    private Integer count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
