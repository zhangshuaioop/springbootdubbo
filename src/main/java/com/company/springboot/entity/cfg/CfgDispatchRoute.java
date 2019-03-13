package com.company.springboot.entity.cfg;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * 项目规则  - zs
 */
@ApiModel(value = "项目规则")
public class CfgDispatchRoute extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "项目id", example = "1", required = true)
    private Integer projectId;

    @ApiModelProperty(value = "项目名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "项目人员", example = "1", required = true)
    private String persons;

    @ApiModelProperty(value = "生效时间", example = "1", required = true)
    private Date startTime;

    @ApiModelProperty(value = "是否是项目0否1是", example = "1", required = true)
    private Boolean flagProject;

    @ApiModelProperty(value = "是否是默认项目0否1是", example = "1", required = true)
    private Boolean flagDefault;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "0失效1生效", example = "1", required = true)
    private Boolean flagTakeStatus;

    @ApiModelProperty(value = "1校验通过，0不通过", example = "1", required = true)
    private Boolean flagCheck;

    /**
     * 公司id
     */
    private Integer companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean getFlagProject() {
        return flagProject;
    }

    public void setFlagProject(Boolean flagProject) {
        this.flagProject = flagProject;
    }

    public Boolean getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(Boolean flagDefault) {
        this.flagDefault = flagDefault;
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

    public Boolean getFlagTakeStatus() {
        return flagTakeStatus;
    }

    public void setFlagTakeStatus(Boolean flagTakeStatus) {
        this.flagTakeStatus = flagTakeStatus;
    }

    public Boolean getFlagCheck() {
        return flagCheck;
    }

    public void setFlagCheck(Boolean flagCheck) {
        this.flagCheck = flagCheck;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "CfgDispatchRoute{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", persons='" + persons + '\'' +
                ", startTime=" + startTime +
                ", flagProject=" + flagProject +
                ", flagDefault=" + flagDefault +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", flagTakeStatus=" + flagTakeStatus +
                ", flagCheck=" + flagCheck +
                ", companyId=" + companyId +
                '}';
    }
}