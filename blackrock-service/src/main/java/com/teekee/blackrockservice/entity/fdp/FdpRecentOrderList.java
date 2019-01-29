package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("工单列表list")
public class FdpRecentOrderList extends BaseEntity{
    private String StoreName;

    private String serviceProvince;

    private String serviceCity;

    private String serviceDistrict;

    private String serviceAddress;

    private String ymd;

    private String AmPm;

    private String timeHour;

    private Date serviceTime;

    private Integer orderId;

    private String dispatchStatus;

    private String nyr;

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getNyr() {
        return nyr;
    }

    public void setNyr(String nyr) {
        this.nyr = nyr;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
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


    public String getAmPm() {
        return AmPm;
    }

    public void setAmPm(String amPm) {
        AmPm = amPm;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public String getTimeHour() {
        return timeHour;
    }

    public void setTimeHour(String timeHour) {
        this.timeHour = timeHour;
    }
}
