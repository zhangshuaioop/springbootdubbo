package com.platform.springboot.entity.fdp;

/**
 * 客服雇主汇总实体
 * @Author Niting
 * @date 2018/6/14
 **/
public class GetDemandCollectList {
    private Integer companyId;
    private String companyName;       //雇主名称
    private Integer demandTotal;      //雇主故障工单总量
    private Integer demCompleteNum;   //雇主已完成数量
    private Integer demUncompleteNum; //雇主未完成数量

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

    public Integer getDemandTotal() {
        return demandTotal;
    }

    public void setDemandTotal(Integer demandTotal) {
        this.demandTotal = demandTotal;
    }

    public Integer getDemCompleteNum() {
        return demCompleteNum;
    }

    public void setDemCompleteNum(Integer demCompleteNum) {
        this.demCompleteNum = demCompleteNum;
    }

    public Integer getDemUncompleteNum() {
        return demUncompleteNum;
    }

    public void setDemUncompleteNum(Integer demUncompleteNum) {
        this.demUncompleteNum = demUncompleteNum;
    }
}
