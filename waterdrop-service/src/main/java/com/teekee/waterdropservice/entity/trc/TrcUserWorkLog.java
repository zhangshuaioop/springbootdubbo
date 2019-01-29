package com.teekee.waterdropservice.entity.trc;

import java.util.Date;

/**
 * @Description 用户打开关闭日志表实体
 * @Author zhanghao
 * @Date 2018/11/7 - 9:56
 * @Version 1.0
 **/
public class TrcUserWorkLog {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 操作时间
     */
    private Date workTime;
    /**
     * 0打开1关闭
     */
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TrcUserWorkLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", workTime=" + workTime +
                ", status=" + status +
                '}';
    }
}
