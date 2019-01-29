package com.teekee.commoncomponets.entity.message.publicss;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 天气Entity
 * @author zhangshuai
 * @version 2018-07-17
 */
public class Weather extends BaseEntity {


    @ApiModelProperty(value = "区域Id", example = "上海")
    private String areaId;

    @ApiModelProperty(value = "城市名称", example = "上海")
    private String area;

    @ApiModelProperty(value = "(可选)是否需要当天每3/6小时一次的天气预报列表。1为需要，0为不需要。", example = "1")
    private String need3HourForcast;

    @ApiModelProperty(value = "(可选)是否需要天气预警。1为需要，0为不需要。", example = "1")
    private String needAlarm;

    @ApiModelProperty(value = "是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0. 1为需要 0为不", example = "1")
    private String needHourData;

    @ApiModelProperty(value = "是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。", example = "1")
    private String needIndex;

    @ApiModelProperty(value = "是否需要返回7天数据中的后4天。1为返回，0为不返回。", example = "1")
    private String needMoreDay;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNeed3HourForcast() {
        return need3HourForcast;
    }

    public void setNeed3HourForcast(String need3HourForcast) {
        this.need3HourForcast = need3HourForcast;
    }

    public String getNeedAlarm() {
        return needAlarm;
    }

    public void setNeedAlarm(String needAlarm) {
        this.needAlarm = needAlarm;
    }

    public String getNeedHourData() {
        return needHourData;
    }

    public void setNeedHourData(String needHourData) {
        this.needHourData = needHourData;
    }

    public String getNeedIndex() {
        return needIndex;
    }

    public void setNeedIndex(String needIndex) {
        this.needIndex = needIndex;
    }

    public String getNeedMoreDay() {
        return needMoreDay;
    }

    public void setNeedMoreDay(String needMoreDay) {
        this.needMoreDay = needMoreDay;
    }
}
