package com.teekee.blackrockservice.entity.trc;

/**
 * @Author Niting
 * @date 2018/7/16
 **/
public class SmsParam {
    private String userid;
    private String pwd;
    private String mobile;
    private String content;
    private String timestamp;
    private String svrtype;
    private String exno;
    private String custid;
    private String exdata;

    private String messageId;

    private String businessType;

    private Integer trcSmsLogId;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSvrtype() {
        return svrtype;
    }

    public void setSvrtype(String svrtype) {
        this.svrtype = svrtype;
    }

    public String getExno() {
        return exno;
    }

    public void setExno(String exno) {
        this.exno = exno;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getExdata() {
        return exdata;
    }

    public void setExdata(String exdata) {
        this.exdata = exdata;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getTrcSmsLogId() {
        return trcSmsLogId;
    }

    public void setTrcSmsLogId(Integer trcSmsLogId) {
        this.trcSmsLogId = trcSmsLogId;
    }
}
