package com.platform.springboot.entity.syscompany.response;

/**
 * @description: redis缓存权限信息
 * @author: zhangshuai
 * @create: 2018-12-28 14:41
 */
public class RedisCompanyPermissionApiRes {


    //公司id
    private Integer companyId;

    //用户id
    private Integer userId;

    //apiUrl
    private String apiUrl;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public String toString() {
        return "RedisCompanyPermissionApiRes{" +
                "companyId=" + companyId +
                ", userId=" + userId +
                ", apiUrl='" + apiUrl + '\'' +
                '}';
    }
}
