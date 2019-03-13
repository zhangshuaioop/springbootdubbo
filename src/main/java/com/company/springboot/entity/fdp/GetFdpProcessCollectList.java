package com.company.springboot.entity.fdp;

/**
 * 客服汇总实体
 * @Author Niting
 * @date 2018/6/14
 **/
public class GetFdpProcessCollectList {
    private Integer processTotal;       //故障单总数量
    private Integer reportTotal;
    private Integer WechatNum;          //微信报障数量
    private Integer posNum;             //伯俊报障数量
    private Integer sysNum;             //本系统故障数量
    private Integer completeNum;        //已完成数量
    private Integer uncompleteNum;      //未完成数量
    private Integer cancelNum;          //取消工单数量
    private String estimatedPriceCompleteNum;    //已完成预计总费用
    private String estimatedPriceUncompleteNum;  //未完成预计总费用
    private String actualPriceCompleteNum;       //已完成实际总费用
    private String actualPriceUncompleteNum;     //未完成实际总费用
    private String estimatedPriceUnit;
    private String actualPriceUnit;

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    //private List<GetDemandCollectList> getDemandCollectLists;      //雇主汇总
    //private List<GetBelongPersonCollerctList> getBelongPersonCollerctLists;     //所属人汇总


    //public List<GetDemandCollectList> getGetDemandCollectLists() {
    //    return getDemandCollectLists;
    //}
    //
    //public void setGetDemandCollectLists(List<GetDemandCollectList> getDemandCollectLists) {
    //    this.getDemandCollectLists = getDemandCollectLists;
    //}
    //
    //public List<GetBelongPersonCollerctList> getGetBelongPersonCollerctLists() {
    //    return getBelongPersonCollerctLists;
    //}
    //
    //public void setGetBelongPersonCollerctLists(List<GetBelongPersonCollerctList> getBelongPersonCollerctLists) {
    //    this.getBelongPersonCollerctLists = getBelongPersonCollerctLists;
    //}


    public Integer getReportTotal() {
        return reportTotal;
    }

    public void setReportTotal(Integer reportTotal) {
        this.reportTotal = reportTotal;
    }

    public Integer getProcessTotal() {
        return processTotal;
    }

    public void setProcessTotal(Integer processTotal) {
        this.processTotal = processTotal;
    }

    public Integer getWechatNum() {
        return WechatNum;
    }

    public void setWechatNum(Integer wechatNum) {
        WechatNum = wechatNum;
    }

    public Integer getPosNum() {
        return posNum;
    }

    public void setPosNum(Integer posNum) {
        this.posNum = posNum;
    }

    public Integer getSysNum() {
        return sysNum;
    }

    public void setSysNum(Integer sysNum) {
        this.sysNum = sysNum;
    }

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
    }

    public Integer getUncompleteNum() {
        return uncompleteNum;
    }

    public void setUncompleteNum(Integer uncompleteNum) {
        this.uncompleteNum = uncompleteNum;
    }

    public Integer getCancelNum() {
        return cancelNum;
    }

    public void setCancelNum(Integer cancelNum) {
        this.cancelNum = cancelNum;
    }

    public String getEstimatedPriceCompleteNum() {
        return estimatedPriceCompleteNum;
    }

    public void setEstimatedPriceCompleteNum(String estimatedPriceCompleteNum) {
        this.estimatedPriceCompleteNum = estimatedPriceCompleteNum;
    }

    public String getEstimatedPriceUncompleteNum() {
        return estimatedPriceUncompleteNum;
    }

    public void setEstimatedPriceUncompleteNum(String estimatedPriceUncompleteNum) {
        this.estimatedPriceUncompleteNum = estimatedPriceUncompleteNum;
    }

    public String getActualPriceCompleteNum() {
        return actualPriceCompleteNum;
    }

    public void setActualPriceCompleteNum(String actualPriceCompleteNum) {
        this.actualPriceCompleteNum = actualPriceCompleteNum;
    }

    public String getActualPriceUncompleteNum() {
        return actualPriceUncompleteNum;
    }

    public void setActualPriceUncompleteNum(String actualPriceUncompleteNum) {
        this.actualPriceUncompleteNum = actualPriceUncompleteNum;
    }
}
