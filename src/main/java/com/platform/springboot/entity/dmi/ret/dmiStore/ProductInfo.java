package com.platform.springboot.entity.dmi.ret.dmiStore;

/**
 * 套餐包含的产品信息
 *
 * @author Wujun
 * @create 2017年06月13日 11:05
 */
public class ProductInfo {
    // 产品名
    private String productDescription;
    // 产品大类
    private String fatherCategory;
    // 产品小类
    private String childCategory;
    // 品牌
    private String brandName;
    // 子品牌
    private String subBrand;
    // ISP服务商
    private String ispService;
    // 产品特有信息
    private Object objectInfo;
    // 产品分类
    private String productCategoryType;

    public String getProductCategoryType() {
        return productCategoryType;
    }

    public void setProductCategoryType(String productCategoryType) {
        this.productCategoryType = productCategoryType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getFatherCategory() {
        return fatherCategory;
    }

    public void setFatherCategory(String fatherCategory) {
        this.fatherCategory = fatherCategory;
    }

    public String getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(String childCategory) {
        this.childCategory = childCategory;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIspService() {
        return ispService;
    }

    public void setIspService(String ispService) {
        this.ispService = ispService;
    }

    public Object getObjectInfo() {
        return objectInfo;
    }

    public void setObjectInfo(Object objectInfo) {
        this.objectInfo = objectInfo;
    }

    public String getSubBrand() {
        return subBrand;
    }

    public void setSubBrand(String subBrand) {
        this.subBrand = subBrand;
    }
}
