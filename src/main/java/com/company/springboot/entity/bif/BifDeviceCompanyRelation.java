package com.company.springboot.entity.bif;

import com.company.springboot.base.BaseEntity;
import com.company.springboot.entity.dmi.DmiStoreUploadFile;
import com.company.springboot.base.BaseEntity;
import com.company.springboot.entity.dmi.DmiStoreUploadFile;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BifDeviceCompanyRelation extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "设备名称", example = "1", required = true)
    private String deviceName;

    @ApiModelProperty(value = "设备序号", example = "1", required = true)
    private String deviceSn;

    @ApiModelProperty(value = "brand", example = "1", required = true)
    private String brand;

    @ApiModelProperty(value = "品牌", example = "1", required = true)
    private String model;

    @ApiModelProperty(value = "型号id", example = "1", required = true)
    private Integer modelId;

    @ApiModelProperty(value = "分类id", example = "1", required = true)
    private Integer catalogId;

    @ApiModelProperty(value = "技术参数", example = "1", required = true)
    private String techParam;

    @ApiModelProperty(value = "是否已删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "是否可使用", example = "1", required = true)
    private Boolean flagUsable;

    @ApiModelProperty(value = "是否维修中", example = "1", required = true)
    private Boolean flagWarranty;

    @ApiModelProperty(value = "维保到期日期", example = "1", required = true)
    private Date warrantyExpireDate;

    @ApiModelProperty(value = "停用日期", example = "1", required = true)
    private Date useExpireDate;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人id", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "修改时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "修改人id", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "备注", example = "1", required = true)
    private String memo;

    private Integer companyId;

    private String assetSn;

    private Date purchaseDate;

    private Integer supplyCompanyId;

    private BigDecimal purchasePrice;

    private String monetaryUnit;

    private Boolean flagAssign;

    private List<BifDeviceUploadFile> list;

    private List<DmiStoreUploadFile> storeUploadFileList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getTechParam() {
        return techParam;
    }

    public void setTechParam(String techParam) {
        this.techParam = techParam == null ? null : techParam.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagUsable() {
        return flagUsable;
    }

    public void setFlagUsable(Boolean flagUsable) {
        this.flagUsable = flagUsable;
    }

    public Date getWarrantyExpireDate() {
        return warrantyExpireDate;
    }

    public void setWarrantyExpireDate(Date warrantyExpireDate) {
        this.warrantyExpireDate = warrantyExpireDate;
    }

    public Date getUseExpireDate() {
        return useExpireDate;
    }

    public void setUseExpireDate(Date useExpireDate) {
        this.useExpireDate = useExpireDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Boolean getFlagWarranty() {
        return flagWarranty;
    }

    public void setFlagWarranty(Boolean flagWarranty) {
        this.flagWarranty = flagWarranty;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getAssetSn() {
        return assetSn;
    }

    public void setAssetSn(String assetSn) {
        this.assetSn = assetSn;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getSupplyCompanyId() {
        return supplyCompanyId;
    }

    public void setSupplyCompanyId(Integer supplyCompanyId) {
        this.supplyCompanyId = supplyCompanyId;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getMonetaryUnit() {
        return monetaryUnit;
    }

    public void setMonetaryUnit(String monetaryUnit) {
        this.monetaryUnit = monetaryUnit;
    }

    public Boolean getFlagAssign() {
        return flagAssign;
    }

    public void setFlagAssign(Boolean flagAssign) {
        this.flagAssign = flagAssign;
    }

    public List<BifDeviceUploadFile> getList() {
        return list;
    }

    public void setList(List<BifDeviceUploadFile> list) {
        this.list = list;
    }

    public List<DmiStoreUploadFile> getStoreUploadFileList() {
        return storeUploadFileList;
    }

    public void setStoreUploadFileList(List<DmiStoreUploadFile> storeUploadFileList) {
        this.storeUploadFileList = storeUploadFileList;
    }
}