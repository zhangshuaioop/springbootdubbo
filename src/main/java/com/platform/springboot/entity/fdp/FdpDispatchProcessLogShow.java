package com.platform.springboot.entity.fdp;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/9/20
 **/
public class FdpDispatchProcessLogShow {
    private String info;
    private Date dealTime;
    private boolean flagTransfer;
    private String  burningTime;

    /**
     * 转移类型0采购转发1派工转发
     */
    private Integer transferType;

    public String getBurningTime() {
        return burningTime;
    }

    public void setBurningTime(String burningTime) {
        this.burningTime = burningTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public boolean isFlagTransfer() {
        return flagTransfer;
    }

    public void setFlagTransfer(boolean flagTransfer) {
        this.flagTransfer = flagTransfer;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }
}
