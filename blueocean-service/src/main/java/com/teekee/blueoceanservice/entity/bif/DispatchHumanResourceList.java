package com.teekee.blueoceanservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhanghao
 * @Title: DispatchHumanResourceList
 * @ProjectName BlueOcean
 * @Description: 人力服务商
 * @date 2018/12/28下午1:25
 */
public class DispatchHumanResourceList extends BaseEntity {

    private String defaultProvice;
    private String defaultCity;
    private String firstName;
    private String lastName;
    private String mobile;
    private int userId;
    private boolean flagMyUsed;
    private BigDecimal dispatchAvgFeeStart;
    private BigDecimal dispatchAvgFeeEnd;
    private BigDecimal dispatchMaxFeeStart;
    private BigDecimal dispatchMaxFeeEnd;
    private List<Integer> idList;

    /**
     * 标签id
     */
    private String skillLabelIds;

    /**
     * 自定义标签名称
     */
    private String customLabel;

    private String areaProvice;

    private String areaCity;

    public boolean getFlagMyUsed() {
        return flagMyUsed;
    }

    public void setFlagMyUsed(boolean flagMyUsed) {
        this.flagMyUsed = flagMyUsed;
    }

    public Integer getDealPersonId() {
        return DealPersonId;
    }

    public void setDealPersonId(Integer dealPersonId) {
        DealPersonId = dealPersonId;
    }

    private Integer DealPersonId;



    public String getDefaultProvice() {
        return defaultProvice;
    }

    public void setDefaultProvice(String defaultProvice) {
        this.defaultProvice = defaultProvice;
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getDispatchAvgFeeStart() {
        return dispatchAvgFeeStart;
    }

    public void setDispatchAvgFeeStart(BigDecimal dispatchAvgFeeStart) {
        this.dispatchAvgFeeStart = dispatchAvgFeeStart;
    }

    public BigDecimal getDispatchAvgFeeEnd() {
        return dispatchAvgFeeEnd;
    }

    public void setDispatchAvgFeeEnd(BigDecimal dispatchAvgFeeEnd) {
        this.dispatchAvgFeeEnd = dispatchAvgFeeEnd;
    }

    public BigDecimal getDispatchMaxFeeStart() {
        return dispatchMaxFeeStart;
    }

    public void setDispatchMaxFeeStart(BigDecimal dispatchMaxFeeStart) {
        this.dispatchMaxFeeStart = dispatchMaxFeeStart;
    }

    public BigDecimal getDispatchMaxFeeEnd() {
        return dispatchMaxFeeEnd;
    }

    public void setDispatchMaxFeeEnd(BigDecimal dispatchMaxFeeEnd) {
        this.dispatchMaxFeeEnd = dispatchMaxFeeEnd;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public String getSkillLabelIds() {
        return skillLabelIds;
    }

    public void setSkillLabelIds(String skillLabelIds) {
        this.skillLabelIds = skillLabelIds;
    }

    public String getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(String customLabel) {
        this.customLabel = customLabel;
    }

    public String getAreaProvice() {
        return areaProvice;
    }

    public void setAreaProvice(String areaProvice) {
        this.areaProvice = areaProvice;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    @Override
    public String toString() {
        return "DispatchHumanResourceList{" +
                "defaultProvice='" + defaultProvice + '\'' +
                ", defaultCity='" + defaultCity + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userId=" + userId +
                ", flagMyUsed=" + flagMyUsed +
                ", dispatchAvgFeeStart=" + dispatchAvgFeeStart +
                ", dispatchAvgFeeEnd=" + dispatchAvgFeeEnd +
                ", dispatchMaxFeeStart=" + dispatchMaxFeeStart +
                ", dispatchMaxFeeEnd=" + dispatchMaxFeeEnd +
                ", idList=" + idList +
                ", skillLabelIds='" + skillLabelIds + '\'' +
                ", customLabel='" + customLabel + '\'' +
                ", areaProvice='" + areaProvice + '\'' +
                ", areaCity='" + areaCity + '\'' +
                ", DealPersonId=" + DealPersonId +
                '}';
    }
}
