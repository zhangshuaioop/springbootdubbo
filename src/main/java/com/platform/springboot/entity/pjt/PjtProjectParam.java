package com.platform.springboot.entity.pjt;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/9/28
 **/
public class PjtProjectParam {
    private Integer companyId;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Integer createPerson;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    @Override
    public String toString() {
        return "PjtProjectParam{" +
                "companyId=" + companyId +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                ", createPerson=" + createPerson +
                '}';
    }
}
