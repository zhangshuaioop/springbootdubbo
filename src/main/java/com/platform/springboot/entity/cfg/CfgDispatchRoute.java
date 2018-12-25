package com.platform.springboot.entity.cfg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 项目规则  - zs
 */
@ApiModel(value = "项目规则")
public class CfgDispatchRoute {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "项目id", example = "1", required = true)
    private Integer projectId;

    @ApiModelProperty(value = "项目名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "项目人员", example = "1", required = true)
    private String persons;

    @ApiModelProperty(value = "开始时间", example = "1", required = true)
    private String startTime;

    @ApiModelProperty(value = "0失效1生效", example = "1", required = true)
    private Boolean flagTakeStatus;


    @ApiModelProperty(value = "是否是项目0否1是", example = "1", required = true)
    private boolean flagProject;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private String createTime;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "0失效1生效", example = "1", required = true)
    private Integer status;

    @ApiModelProperty(value = "是否是默认项目0否1是", example = "1", required = true)
    private boolean flagDefault;

    @ApiModelProperty(value = "是否校验通过0是1否", example = "1", required = true)
    private Integer cStatus;

    @ApiModelProperty(value = "0集成商1雇主", example = "1", required = true)
    private boolean objectType;

    @ApiModelProperty(value = "雇主id", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "雇主名称", example = "1", required = true)
    private String companyName;

    @ApiModelProperty(value = "集成商id", example = "1", required = true)
    private Integer vendorsId;

    @ApiModelProperty(value = "集成商名称", example = "1", required = true)
    private String vendorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons == null ? null : persons.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Boolean getFlagTakeStatus() {
        return flagTakeStatus;
    }

    public void setFlagTakeStatus(Boolean flagTakeStatus) {
        this.flagTakeStatus = flagTakeStatus;
    }

    public boolean isObjectType() {
        return objectType;
    }

    public void setObjectType(boolean objectType) {
        this.objectType = objectType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getVendorsId() {
        return vendorsId;
    }

    public void setVendorsId(Integer vendorsId) {
        this.vendorsId = vendorsId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public boolean isFlagProject() {
        return flagProject;
    }

    public void setFlagProject(boolean flagProject) {
        this.flagProject = flagProject;
    }

    public boolean isFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(boolean flagDefault) {
        this.flagDefault = flagDefault;
    }
}