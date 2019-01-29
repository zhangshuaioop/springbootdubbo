package com.teekee.waterdropservice.entity.dmi;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by ray on 2017/1/3.
 */
public class DmiContactCompanyRelationDetail {
    private Integer id = 0;

    private String contactName;

    private String contactNameCn;

    private String contactNameEn;

    private Integer contactId;

    private String telephone;

    private String mobile;

    private String qq;

    private String wechat;

    private Integer companyId;

    private Boolean flagMajor;

    private String department;

    private String position;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNameCn() {
        return contactNameCn;
    }

    public void setContactNameCn(String contactNameCn) {
        this.contactNameCn = contactNameCn;
    }

    public String getContactNameEn() {
        return contactNameEn;
    }

    public void setContactNameEn(String contactNameEn) {
        this.contactNameEn = contactNameEn;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Boolean getFlagMajor() {
        return flagMajor;
    }

    public void setFlagMajor(Boolean flagMajor) {
        this.flagMajor = flagMajor;
    }

    public DmiContactCompanyRelationDetail() {

    }

    public DmiContactCompanyRelationDetail(HashMap<String, Object> map) {
        if (map.containsKey("qq")) setQq(map.get("qq").toString());
        if (map.containsKey("contact_name")) setContactName(map.get("contact_name").toString());
        if (map.containsKey("contact_name_cn")) setContactNameCn(map.get("contact_name_cn").toString());
        if (map.containsKey("contact_name_en")) setContactNameEn(map.get("contact_name_en").toString());
        if (map.containsKey("company_id")) setCompanyId(Integer.parseInt(map.get("company_id").toString()));
        if (map.containsKey("contact_id")) setContactId(Integer.parseInt(map.get("contact_id").toString()));
        if (map.containsKey("flag_major")) setFlagMajor(Boolean.parseBoolean(map.get("flag_major").toString()));
        if (map.containsKey("mobile")) setMobile(map.get("mobile").toString());
        if (map.containsKey("wechat")) setWechat(map.get("wechat").toString());
        if (map.containsKey("telephone")) setTelephone(map.get("telephone").toString());
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("position")) setPosition(map.get("position").toString());
        if (map.containsKey("department")) setDepartment(map.get("department").toString());
        if (map.containsKey("update_time")) setUpdateTime((Date) map.get("update_time"));
    }
}
