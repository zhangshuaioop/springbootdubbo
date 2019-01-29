package com.teekee.waterdropservice.Thread;

/**
 * @author Wujun
 * @create 2017年11月29日 14:14
 */
public class ImportDTO {

    private String fileName;

    private int belongCompanyId;

    private int userId;

    private String batchInsertCode;

    public String getBatchInsertCode() {
        return batchInsertCode;
    }

    public void setBatchInsertCode(String batchInsertCode) {
        this.batchInsertCode = batchInsertCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getBelongCompanyId() {
        return belongCompanyId;
    }

    public void setBelongCompanyId(int belongCompanyId) {
        this.belongCompanyId = belongCompanyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
