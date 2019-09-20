package com.example.componets.entity.sys;

import com.example.componets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "业务公司")
public class SysCompany extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "公司log", example = "1", required = true)
    private String logUrl;

    @ApiModelProperty(value = "电话", example = "1", required = true)
    private String phone;

    @ApiModelProperty(value = "手机", example = "1", required = true)
    private String mobile;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String emil;

    @ApiModelProperty(value = "地址", example = "1", required = true)
    private String address;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "是否启用0禁用1启用", example = "1", required = true)
    private Boolean flagEnabled;

    @ApiModelProperty(value = "是否删除0未删除1删除", example = "1", required = true)
    private Boolean flagDelete;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createDate;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateDate;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Long createBy;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Long updateBy;

    @ApiModelProperty(value = "全局搜索", example = "1", required = true)
    private String search;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil == null ? null : emil.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getFlagEnabled() {
        return flagEnabled;
    }

    public void setFlagEnabled(Boolean flagEnabled) {
        this.flagEnabled = flagEnabled;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    @Override
    public String toString() {
        return "SysCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logUrl='" + logUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emil='" + emil + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", flagEnabled=" + flagEnabled +
                ", flagDelete=" + flagDelete +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", search='" + search + '\'' +
                '}';
    }
}