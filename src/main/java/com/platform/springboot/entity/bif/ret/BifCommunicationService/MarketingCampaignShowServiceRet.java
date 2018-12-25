package com.platform.springboot.entity.bif.ret.BifCommunicationService;

/**
 * 显示通信套餐中的服务商信息-返回结果
 *
 * @author Wujun
 * @create 2017年06月09日 10:56
 */
public class MarketingCampaignShowServiceRet {
    // 服务商ID
    private Integer id;
    // 服务商名字
    private String serviceName;
    // 地址
    private String address;
    // 联系人
    private String contactName;
    // 手机
    private String mobile;
    // 座机
    private String telephone;
    // 服务商备注
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
