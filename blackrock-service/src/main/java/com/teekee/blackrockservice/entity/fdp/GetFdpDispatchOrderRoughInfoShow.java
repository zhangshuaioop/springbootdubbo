package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;

/**
 * @Author Niting
 * @date 2018/7/23
 **/
public class GetFdpDispatchOrderRoughInfoShow extends BaseEntity{
    private String hrConfirmTime;
    private String hrStartDerviceTime;
    private String lastDealTime;
    private String serviceProvince;
    private String serviceCity;
    private String serviceDistrict;
    private String serviceAddress;
    private String brandName;
    private String dispatchStatus;
    private String storeName;

    public String getHrConfirmTime() {
        return hrConfirmTime;
    }

    public void setHrConfirmTime(String hrConfirmTime) {
        this.hrConfirmTime = hrConfirmTime;
    }

    public String getHrStartDerviceTime() {
        return hrStartDerviceTime;
    }

    public void setHrStartDerviceTime(String hrStartDerviceTime) {
        this.hrStartDerviceTime = hrStartDerviceTime;
    }

    public String getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(String lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    public String getServiceProvince() {
        return serviceProvince;
    }

    public void setServiceProvince(String serviceProvince) {
        this.serviceProvince = serviceProvince;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getServiceDistrict() {
        return serviceDistrict;
    }

    public void setServiceDistrict(String serviceDistrict) {
        this.serviceDistrict = serviceDistrict;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
