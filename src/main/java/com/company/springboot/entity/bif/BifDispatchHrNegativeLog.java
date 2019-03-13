package com.company.springboot.entity.bif;

import java.util.Date;

public class BifDispatchHrNegativeLog {
    private Integer id;

    private Integer hrId;

    private String negativeType;

    private String negativeReason;

    private String negativeOtherReason;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private boolean flagRecommend;

    public boolean isFlagRecommend() {
        return flagRecommend;
    }

    public void setFlagRecommend(boolean flagRecommend) {
        this.flagRecommend = flagRecommend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId == null ? null : hrId;
    }

    public String getNegativeType() {
        return negativeType;
    }

    public void setNegativeType(String negativeType) {
        this.negativeType = negativeType == null ? null : negativeType.trim();
    }

    public String getNegativeReason() {
        return negativeReason;
    }

    public void setNegativeReason(String negativeReason) {
        this.negativeReason = negativeReason == null ? null : negativeReason.trim();
    }

    public String getNegativeOtherReason() {
        return negativeOtherReason;
    }

    public void setNegativeOtherReason(String negativeOtherReason) {
        this.negativeOtherReason = negativeOtherReason == null ? null : negativeOtherReason.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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
}