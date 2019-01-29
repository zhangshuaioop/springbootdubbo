package com.teekee.blackrockservice.entity.sys;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@ApiModel(value = "服务商公告list")
public class GetSysAnnouncementWechatList extends BaseEntity {
    private Integer id;
    private String title;
    private String mainPicUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
