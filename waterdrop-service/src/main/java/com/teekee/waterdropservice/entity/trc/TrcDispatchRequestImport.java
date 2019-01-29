package com.teekee.waterdropservice.entity.trc;

import java.util.Date;

public class TrcDispatchRequestImport {
    private Integer id;

    private String batchInsertCode;

    private String status;

    private Integer importCount;

    private Integer operatorId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchInsertCode() {
        return batchInsertCode;
    }

    public void setBatchInsertCode(String batchInsertCode) {
        this.batchInsertCode = batchInsertCode == null ? null : batchInsertCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getImportCount() {
        return importCount;
    }

    public void setImportCount(Integer importCount) {
        this.importCount = importCount;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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
}