package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;

/**
 * @Author Niting
 * @date 2018/11/03
 **/
@ApiModel("服务商关联公司及发票show")
public class GetHumanResourceCompanyInvoice extends BaseEntity{
    private Integer id;
    private String belongCompany;
    private String belongCompanyBussinessLicenseCode;
    private boolean flagProvideInvoice;
    private String provideInvoiceType;
    private BigDecimal provideInvoiceRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(String belongCompany) {
        this.belongCompany = belongCompany;
    }

    public String getBelongCompanyBussinessLicenseCode() {
        return belongCompanyBussinessLicenseCode;
    }

    public void setBelongCompanyBussinessLicenseCode(String belongCompanyBussinessLicenseCode) {
        this.belongCompanyBussinessLicenseCode = belongCompanyBussinessLicenseCode;
    }

    public boolean isFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public String getProvideInvoiceType() {
        return provideInvoiceType;
    }

    public void setProvideInvoiceType(String provideInvoiceType) {
        this.provideInvoiceType = provideInvoiceType;
    }

    public BigDecimal getProvideInvoiceRate() {
        return provideInvoiceRate;
    }

    public void setProvideInvoiceRate(BigDecimal provideInvoiceRate) {
        this.provideInvoiceRate = provideInvoiceRate;
    }
}
