package com.platform.springboot.entity.bif.ret.BifBuilding;

import java.util.Date;

/**
 * 根据楼查询地址信息列表-返回信息
 *
 * @author Wujun
 * @create 2017年06月28日 16:25
 */
public class AddressListRet {
    private Integer id;
    private String road;
    private Date createTime;
    private String createPerson;
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }
}
