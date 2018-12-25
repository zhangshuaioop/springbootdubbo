package com.platform.springboot.entity.ret.dmi.DmiDeviceStoreRelation;

import java.util.Date;

/**
 * 查询已分配的某个设备详情
 *
 * @author Wujun
 * @create 2017年11月17日 9:51
 */
public class SelectByDeviceIdRet {
    private String storeName;
    private int storeId;
    private String address;
    private Date assignDate;
    private Date startUsingDate;
    private String storeMemo;

    public String getStoreMemo() {
        return storeMemo;
    }

    public void setStoreMemo(String storeMemo) {
        this.storeMemo = storeMemo;
    }

    public Date getStartUsingDate() {
        return startUsingDate;
    }

    public void setStartUsingDate(Date startUsingDate) {
        this.startUsingDate = startUsingDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
}
