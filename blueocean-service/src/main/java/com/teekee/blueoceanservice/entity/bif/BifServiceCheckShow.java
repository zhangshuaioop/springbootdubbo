package com.teekee.blueoceanservice.entity.bif;

import java.util.Date;

public class BifServiceCheckShow {

    private String serviceName;
    private String mobile;
    private String sex;
    private Date CreateTime;
    private Date registerTime;
    private String idType;
    private String idCode;
    private Date validApplyTime;
    private String positiveImageUrl;
    private String contraryImageUrl;
    private String handheldImageUrl;
    private String headPortraitUrl;

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public String getPositiveImageUrl() {
        return positiveImageUrl;
    }

    public void setPositiveImageUrl(String positiveImageUrl) {
        this.positiveImageUrl = positiveImageUrl;
    }

    public String getContraryImageUrl() {
        return contraryImageUrl;
    }

    public void setContraryImageUrl(String contraryImageUrl) {
        this.contraryImageUrl = contraryImageUrl;
    }

    public String getHandheldImageUrl() {
        return handheldImageUrl;
    }

    public void setHandheldImageUrl(String handheldImageUrl) {
        this.handheldImageUrl = handheldImageUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Date getValidApplyTime() {
        return validApplyTime;
    }

    public void setValidApplyTime(Date validApplyTime) {
        this.validApplyTime = validApplyTime;
    }

    @Override
    public String toString() {
        return "BifServiceCheckShow{" +
                "serviceName='" + serviceName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex='" + sex + '\'' +
                ", CreateTime=" + CreateTime +
                ", registerTime=" + registerTime +
                ", idType='" + idType + '\'' +
                ", idCode='" + idCode + '\'' +
                ", validApplyTime=" + validApplyTime +
                ", positiveImageUrl='" + positiveImageUrl + '\'' +
                ", contraryImageUrl='" + contraryImageUrl + '\'' +
                ", handheldImageUrl='" + handheldImageUrl + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                '}';
    }
}
