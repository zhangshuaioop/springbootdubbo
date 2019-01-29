package com.teekee.waterdropservice.entity.sys;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "系统公司关系接口表")
public class SysCompanyRelation extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "授权公司ID", example = "1", required = true)
    private Integer empowerCompanyId;

    @ApiModelProperty(value = "被授权的公司ID", example = "1", required = true)
    private Integer authorizedCompanyId;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "到期日期", example = "1", required = true)
    private Date expireDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpowerCompanyId() {
        return empowerCompanyId;
    }

    public void setEmpowerCompanyId(Integer empowerCompanyId) {
        this.empowerCompanyId = empowerCompanyId;
    }

    public Integer getAuthorizedCompanyId() {
        return authorizedCompanyId;
    }

    public void setAuthorizedCompanyId(Integer authorizedCompanyId) {
        this.authorizedCompanyId = authorizedCompanyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "SysCompanyRelation{" +
                "id=" + id +
                ", empowerCompanyId=" + empowerCompanyId +
                ", authorizedCompanyId=" + authorizedCompanyId +
                ", createTime=" + createTime +
                ", expireDate=" + expireDate +
                '}';
    }
}