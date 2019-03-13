package com.company.springboot.entity.cfg;

import com.company.springboot.base.BaseEntity;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/9/29
 **/
public class GetCfgDispatchModelConfigList extends BaseEntity {
    private Integer id;
    private String companyName;
    private String projectName;
    private String modelName;
    private String createPerson;
    private Date createTime;
    private boolean flagAvaliable;

    public boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
