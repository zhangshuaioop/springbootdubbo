package com.platform.springboot.entity.fdp;

import java.util.Date;

/**
 * 查看派工转发记录-返回结果
 *
 * @author Wujun
 * @create 2018年02月01日 15:41
 */
public class FdpFaultDispatchTransferLogShowResp {
    private String info;

    private Date transferTime;

    /**
     * 转移类型0采购转发1派工转发
     */
    private Integer transferType;


    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }
}
