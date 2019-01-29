package com.teekee.waterdropservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;

/**
 * @author zhanghao
 * @Title: FdbOrderFindPage
 * @ProjectName WaterDrop
 * @Description: 工单分页实体
 * @date 2019/1/17上午9:24
 */
public class FdbOrderFindPage extends BaseEntity {
    Integer requestId;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "FdbOrderFindPage{" +
                "requestId=" + requestId +
                '}';
    }
}
