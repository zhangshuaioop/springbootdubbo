package com.platform.springboot.entity.dmi;

import com.platform.springboot.utils.DateUtil;

import java.util.Date;
import java.util.HashMap;

public class DmiBrand {
    private Integer id = 0;

    private String brandName;

    private String brandNameCn;

    private String brandNameEn;

    private String brandLogoUrl;

    private Date brandCreateDate;

    private String brandCreateDateStr;

    private String brandCode;

    private Integer companyId;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Date createTime;

    private String createTimeStr;

    private Integer createPerson;

    private Date updateTime;

    private String updateTimeStr;

    private Integer updatePerson;

    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandNameCn() {
        return brandNameCn;
    }

    public void setBrandNameCn(String brandNameCn) {
        this.brandNameCn = brandNameCn == null ? null : brandNameCn.trim();
    }

    public String getBrandNameEn() {
        return brandNameEn;
    }

    public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn == null ? null : brandNameEn.trim();
    }

    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

    public void setBrandLogoUrl(String brandLogoUrl) {
        this.brandLogoUrl = brandLogoUrl == null ? null : brandLogoUrl.trim();
    }

    public Date getBrandCreateDate() {
        return brandCreateDate;
    }

    public void setBrandCreateDate(Date brandCreateDate) {
        this.brandCreateDate = brandCreateDate;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public String getBrandCreateDateStr() {
        return brandCreateDateStr;
    }

    public void setBrandCreateDateStr(String brandCreateDateStr) {
        this.brandCreateDateStr = brandCreateDateStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public DmiBrand() {
    }

    public DmiBrand(HashMap<String, Object> map) {
        if (map.containsKey("brand_code")) setBrandCode(map.get("brand_code").toString());
        if (map.containsKey("company_id")) setCompanyId(Integer.parseInt(map.get("company_id").toString()));
        if (map.containsKey("memo")) setMemo(map.get("memo").toString());
        if (map.containsKey("brand_name")) setBrandName(map.get("brand_name").toString());
        if (map.containsKey("brand_name_en")) setBrandNameEn(map.get("brand_name_en").toString());
        if (map.containsKey("brand_name_cn")) setBrandNameCn(map.get("brand_name_cn").toString());
        if (map.containsKey("flag_available")) setFlagAvailable(Boolean.parseBoolean(map.get("flag_available").toString()));
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("flag_deleted")) setFlagDeleted(Boolean.parseBoolean(map.get("flag_deleted").toString()));
        if (map.containsKey("brand_logo_url")) setBrandLogoUrl(map.get("brand_logo_url").toString());

        if (map.containsKey("brand_create_date")) {
            String cd = map.get("brand_create_date").toString();
            if (cd.endsWith(".0")) cd = cd.substring(0, cd.length() - 2);
            setBrandCreateDate(DateUtil.formatString2Date(cd));
        }

        if (map.containsKey("update_time")) setUpdateTime((Date) map.get("update_time"));

    }
}