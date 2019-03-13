package com.company.springboot.entity.fdp;

import com.company.springboot.base.BaseEntity;

public class FaultOrderRequestCountByCompany extends BaseEntity {
    private String companyName;
    private int allCount;
    private int completeCount;
    private int unCompleteCount;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(int completeCount) {
        this.completeCount = completeCount;
    }

    public int getUnCompleteCount() {
        return unCompleteCount;
    }

    public void setUnCompleteCount(int unCompleteCount) {
        this.unCompleteCount = unCompleteCount;
    }
}
