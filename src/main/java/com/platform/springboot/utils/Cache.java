package com.platform.springboot.utils;

import java.util.Date;

/**
 * @Description 缓存对象
 * @Author zhanghao
 * @Date 2018/11/27
 * @Version 1.0
 **/
public class Cache {

    /**
     * 缓存ID
     */
    private String key;
    /**
     * 当前执行了多少条
     */
    private Object newCount;
    /**
     * 总数
     */
    private Object count;
    /**
     * 多少秒后过期
     */
    private long timeOut;
    /**
     * 过期时间
     */
    private Date outDate;
    /**
     * 是否终止
     */
    private boolean expired;

    public Cache() {
        super();
    }

    public Cache(String key, Object newCount, Object count, long timeOut, Date outDate, boolean expired) {
        this.key = key;
        this.newCount = newCount;
        this.count = count;
        this.timeOut = timeOut;
        this.outDate = outDate;
        this.expired = expired;
    }

    public String getKey() {
        return key;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setKey(String string) {
        key = string;
    }

    public void setTimeOut(long l) {
        timeOut = l;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean b) {
        expired = b;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Object getNewCount() {
        return newCount;
    }

    public void setNewCount(Object newCount) {
        this.newCount = newCount;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }
}
