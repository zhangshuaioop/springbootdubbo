package com.platform.springboot.entity.sysconsole;

import com.platform.springboot.base.BaseEntity;

import java.util.Date;

/**
 * @author zhanghao
 * @Title: SysAnnouncementWechat
 * @ProjectName BlueOcean
 * @Description: 服务商公告
 * @date 2019/1/2下午2:20
 */
public class SysAnnouncementWechat extends BaseEntity {

    private Integer id;

    private String title;

    private String mainPicUrl;

    private Boolean flagPublished;

    private Date publishTime;

    private Boolean flagDeleted;

    private Boolean flagAvaliable;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private String content;

    private String createPerson;

    private String updatePerson;

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl == null ? null : mainPicUrl.trim();
    }

    public Boolean getFlagPublished() {
        return flagPublished;
    }

    public void setFlagPublished(Boolean flagPublished) {
        this.flagPublished = flagPublished;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "SysAnnouncementWechat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mainPicUrl='" + mainPicUrl + '\'' +
                ", flagPublished=" + flagPublished +
                ", publishTime=" + publishTime +
                ", flagDeleted=" + flagDeleted +
                ", flagAvaliable=" + flagAvaliable +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                ", content='" + content + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", updatePerson='" + updatePerson + '\'' +
                '}';
    }
}
