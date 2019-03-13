package com.company.springboot.entity.fdp;

/**
 * 客服所属人汇总实体
 * @Author Niting
 * @date 2018/6/14
 **/
public class GetBelongPersonCollerctList {
    private Integer belongPersonId;
    private String belongPersonName;         //所属人姓名
    private Integer belongPersonTotal;       //所属人故障总量
    private Integer belCompleteNum;          //所属人已完成数量
    private Integer belUncompleteNum;        //所属人未完成数量

    public Integer getBelongPersonId() {
        return belongPersonId;
    }

    public void setBelongPersonId(Integer belongPersonId) {
        this.belongPersonId = belongPersonId;
    }

    public String getBelongPersonName() {
        return belongPersonName;
    }

    public void setBelongPersonName(String belongPersonName) {
        this.belongPersonName = belongPersonName;
    }

    public Integer getBelongPersonTotal() {
        return belongPersonTotal;
    }

    public void setBelongPersonTotal(Integer belongPersonTotal) {
        this.belongPersonTotal = belongPersonTotal;
    }

    public Integer getBelCompleteNum() {
        return belCompleteNum;
    }

    public void setBelCompleteNum(Integer belCompleteNum) {
        this.belCompleteNum = belCompleteNum;
    }

    public Integer getBelUncompleteNum() {
        return belUncompleteNum;
    }

    public void setBelUncompleteNum(Integer belUncompleteNum) {
        this.belUncompleteNum = belUncompleteNum;
    }
}
