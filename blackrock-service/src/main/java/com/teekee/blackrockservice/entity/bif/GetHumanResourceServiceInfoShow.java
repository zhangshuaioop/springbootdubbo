package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/7/19
 **/
@ApiModel("服务商实名认证show")
public class GetHumanResourceServiceInfoShow extends BaseEntity{
    private Integer id;
    private String firstName;
    private String lastName;
    private String idType;
    private String idCode;
    private String positiveImageUrl;
    private String contraryImageUrl;
    private String handheldImageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPositiveImageUrl() {
        return positiveImageUrl;
    }

    public void setPositiveImageUrl(String positiveImageUrl) {
        this.positiveImageUrl = positiveImageUrl;
    }

    public String getContraryImageUrl() {
        return contraryImageUrl;
    }

    public void setContraryImageUrl(String contraryImageUrl) {
        this.contraryImageUrl = contraryImageUrl;
    }

    public String getHandheldImageUrl() {
        return handheldImageUrl;
    }

    public void setHandheldImageUrl(String handheldImageUrl) {
        this.handheldImageUrl = handheldImageUrl;
    }
}
