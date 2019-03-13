package com.company.springboot.entity.dmi;

import java.util.Date;
import java.util.HashMap;

public class DmiContactStoreRelationDetail {
    private Integer id = 0;

    private String contactName;

    private String contactNameCn;

    private String contactNameEn;

    private String telephone;

    private String mobile;

    private String qq;

    private String wechat;

    private Boolean flagDeleted;

    private Integer contactId;

    private Integer storeId;

    private Boolean flagMajor;

    private String position;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private String memo;

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
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactNameCn() {
        return contactNameCn;
    }

    public void setContactNameCn(String contactNameCn) {
        this.contactNameCn = contactNameCn == null ? null : contactNameCn.trim();
    }

    public String getContactNameEn() {
        return contactNameEn;
    }

    public void setContactNameEn(String contactNameEn) {
        this.contactNameEn = contactNameEn == null ? null : contactNameEn.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagMajor() {
        return flagMajor;
    }

    public void setFlagMajor(Boolean flagMajor) {
        this.flagMajor = flagMajor;
    }

    public DmiContactStoreRelationDetail() {

    }

    public DmiContactStoreRelationDetail(HashMap<String, Object> map) {
        if (map.containsKey("qq")) setQq(map.get("qq").toString());
        if (map.containsKey("contact_name")) setContactName(map.get("contact_name").toString());
        if (map.containsKey("contact_name_cn")) setContactNameCn(map.get("contact_name_cn").toString());
        if (map.containsKey("contact_name_en")) setContactNameEn(map.get("contact_name_en").toString());
        if (map.containsKey("store_id")) setStoreId(Integer.parseInt(map.get("store_id").toString()));
        if (map.containsKey("contact_id")) setContactId(Integer.parseInt(map.get("contact_id").toString()));
        if (map.containsKey("flag_major")) setFlagMajor(Boolean.parseBoolean(map.get("flag_major").toString()));
        if (map.containsKey("mobile")) setMobile(map.get("mobile").toString());
        if (map.containsKey("wechat")) setWechat(map.get("wechat").toString());
        if (map.containsKey("telephone")) setTelephone(map.get("telephone").toString());
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("position")) setPosition(map.get("position").toString());
        if (map.containsKey("memo")) setMemo(map.get("memo").toString());
        if (map.containsKey("update_time")) setUpdateTime((Date) map.get("update_time"));
    }
}