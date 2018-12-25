package com.platform.springboot.entity.bif;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.util.Date;

/**
 * @Description 网关表实体
 * @Author zhanghao
 * @Date 2018/11/1 - 10:15
 * @Version 1.0
 **/
public class BifCpe extends BaseEntity {
    /**
     * id
     */
    private Integer id;
    /**
     *网关名称
     */
    private String cpeName;
    /**
     *mac地址
     */
    private String cpeMac;
    /**
     *设备号
     */
    private String cpeSn;
    /**
     *业务类型
     */
    private String businessType;
    /**
     *业务id
     */
    private Integer businessId;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *更新时间
     */
    private Date updateTime;
    /**
     *更新人
     */
    private String updatePerson;
    /**
     * 门店名称
     */
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpeName() {
        return cpeName;
    }

    public void setCpeName(String cpeName) {
        this.cpeName = cpeName;
    }

    public String getCpeMac() {
        return cpeMac;
    }

    public void setCpeMac(String cpeMac) {
        this.cpeMac = cpeMac;
    }

    public String getCpeSn() {
        return cpeSn;
    }

    public void setCpeSn(String cpeSn) {
        this.cpeSn = cpeSn;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    @Override
    public String toString() {
        return "BifCpeMapper{" +
                "id=" + id +
                ", cpeName='" + cpeName + '\'' +
                ", cpeMac='" + cpeMac + '\'' +
                ", cpeSn='" + cpeSn + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessId=" + businessId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", updatePerson='" + updatePerson + '\'' +
                '}';
    }
}
