package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;

/**
 * 根据指定门店，查询历史报障记录
 *
 * @author Wujun
 * @create 2018年02月05日 16:34
 */
public class HistoryRecordList {
    private String basicFaultType;
    private Date reportDate;
    private Date finishDate;
    private boolean relation;
    private int reportInfoId;

    public int getReportInfoId() {
        return reportInfoId;
    }

    public void setReportInfoId(int reportInfoId) {
        this.reportInfoId = reportInfoId;
    }

    public String getBasicFaultType() {
        return basicFaultType;
    }

    public void setBasicFaultType(String basicFaultType) {
        this.basicFaultType = basicFaultType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isRelation() {
        return relation;
    }

    public void setRelation(boolean relation) {
        this.relation = relation;
    }
}
