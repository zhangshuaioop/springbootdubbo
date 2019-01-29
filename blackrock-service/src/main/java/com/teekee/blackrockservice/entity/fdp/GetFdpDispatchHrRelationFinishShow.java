package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;

/**
 * @Author Niting
 * @date 2018/7/23
 **/
public class GetFdpDispatchHrRelationFinishShow extends BaseEntity{
    private String hrConfirmTime;
    private String serviceTime;
    private String completeTime;
    private String serviceProvince;
    private String serviceCity;
    private String serviceDistrict;
    private String serviceAddress;
    private String userCompleteProfileFile;
    private String userCompleteProfileFileName;
    private String userCompleteProfilePhoto;
    private String userCompleteProfilePhotoName;
    private String completeProfileTemplateUrl;
    private String completeProfileTemplateName;
    private String userAssmMemo;
    private String brandName;
    private String dispatchStatus;
    private String storeName;

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

    public String getHrConfirmTime() {
        return hrConfirmTime;
    }

    public void setHrConfirmTime(String hrConfirmTime) {
        this.hrConfirmTime = hrConfirmTime;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
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

    public String getUserCompleteProfileFile() {
        return userCompleteProfileFile;
    }

    public void setUserCompleteProfileFile(String userCompleteProfileFile) {
        this.userCompleteProfileFile = userCompleteProfileFile;
    }

    public String getUserCompleteProfileFileName() {
        return userCompleteProfileFileName;
    }

    public void setUserCompleteProfileFileName(String userCompleteProfileFileName) {
        this.userCompleteProfileFileName = userCompleteProfileFileName;
    }

    public String getUserCompleteProfilePhoto() {
        return userCompleteProfilePhoto;
    }

    public void setUserCompleteProfilePhoto(String userCompleteProfilePhoto) {
        this.userCompleteProfilePhoto = userCompleteProfilePhoto;
    }

    public String getUserCompleteProfilePhotoName() {
        return userCompleteProfilePhotoName;
    }

    public void setUserCompleteProfilePhotoName(String userCompleteProfilePhotoName) {
        this.userCompleteProfilePhotoName = userCompleteProfilePhotoName;
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

    public String getUserAssmMemo() {
        return userAssmMemo;
    }

    public void setUserAssmMemo(String userAssmMemo) {
        this.userAssmMemo = userAssmMemo;
    }
}
