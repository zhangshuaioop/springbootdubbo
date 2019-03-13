package com.company.springboot.entity.sys;

/**
 * @author zhanghao
 * @date 2019/1/3下午4:57
 */
public class ParamSysOperationMessage {

    private Integer userId;
    private String messageOperation;
    private String messageObjCode;
    private String messageObjId;
    private Integer dealPersonId;
    private Integer vendorId;
    private Integer companyId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessageOperation() {
        return messageOperation;
    }

    public void setMessageOperation(String messageOperation) {
        this.messageOperation = messageOperation;
    }

    public String getMessageObjCode() {
        return messageObjCode;
    }

    public void setMessageObjCode(String messageObjCode) {
        this.messageObjCode = messageObjCode;
    }

    public String getMessageObjId() {
        return messageObjId;
    }

    public void setMessageObjId(String messageObjId) {
        this.messageObjId = messageObjId;
    }

    public Integer getDealPersonId() {
        return dealPersonId;
    }

    public void setDealPersonId(Integer dealPersonId) {
        this.dealPersonId = dealPersonId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "ParamSysOperationMessage{" +
                "userId=" + userId +
                ", messageOperation='" + messageOperation + '\'' +
                ", messageObjCode='" + messageObjCode + '\'' +
                ", messageObjId='" + messageObjId + '\'' +
                ", dealPersonId=" + dealPersonId +
                ", vendorId=" + vendorId +
                ", companyId=" + companyId +
                '}';
    }
}
