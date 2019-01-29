package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class FdpFaultDispatchOrderInfo extends BaseEntity{
/**
 *@ClassName FdpFaultDispatchOrderInfo
 *@Author Administrator
 *@Date 2018\7\23 0023 15:39
 **/


private String serviceAddress;

    private String serviceProvince;

    private String serviceCity;

    private String serviceDistrict;

    private String brandName;

    private String storeName;

    private String orderTime;

    private String serviceTime;

    private String hrConfirmTime;

    private String completeTime;

    private int hrCount;

    private String dispatchModelRequest;

    private String dispatchDescription;

    private String equipmentRequest;

    private String backupDeviceRequest;

    private String otherRequest;

    private String uploadFileName;

    private String uploadFileUrl;

    private String dispatchStatus;

    private String latitude;

    private String longitude;

    private String hrStartServiceTime;

    private String completeProfileTemplateName;

    private String completeProfileTemplateUrl;
    @ApiModelProperty("采购电话")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompleteProfileTemplateUrl() {
        return completeProfileTemplateUrl;
    }

    public void setCompleteProfileTemplateUrl(String completeProfileTemplateUrl) {
        this.completeProfileTemplateUrl = completeProfileTemplateUrl;
    }

    public String getCompleteProfileTemplateName() {

        return completeProfileTemplateName;
    }

    public void setCompleteProfileTemplateName(String completeProfileTemplateName) {
        this.completeProfileTemplateName = completeProfileTemplateName;
    }

    public String getHrStartServiceTime() {
        return hrStartServiceTime;
    }

    public void setHrStartServiceTime(String hrStartServiceTime) {
        this.hrStartServiceTime = hrStartServiceTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getHrConfirmTime() {
        return hrConfirmTime;
    }

    public void setHrConfirmTime(String hrConfirmTime) {
        this.hrConfirmTime = hrConfirmTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public int getHrCount() {
        return hrCount;
    }

    public void setHrCount(int hrCount) {
        this.hrCount = hrCount;
    }

    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest;
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }
}
