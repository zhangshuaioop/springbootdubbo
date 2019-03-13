package com.company.springboot.entity.bif;

import java.math.BigDecimal;

public class BifAddressDetail extends BifAddress {
    private BigDecimal longitudeMax;
    private BigDecimal longitudeMin;
    private BigDecimal latitudeMax;
    private BigDecimal latitudeMin;

    public BigDecimal getLongitudeMax() {
        return longitudeMax;
    }

    public void setLongitudeMax(BigDecimal longitudeMax) {
        this.longitudeMax = longitudeMax;
    }

    public BigDecimal getLongitudeMin() {
        return longitudeMin;
    }

    public void setLongitudeMin(BigDecimal longitudeMin) {
        this.longitudeMin = longitudeMin;
    }

    public BigDecimal getLatitudeMax() {
        return latitudeMax;
    }

    public void setLatitudeMax(BigDecimal latitudeMax) {
        this.latitudeMax = latitudeMax;
    }

    public BigDecimal getLatitudeMin() {
        return latitudeMin;
    }

    public void setLatitudeMin(BigDecimal latitudeMin) {
        this.latitudeMin = latitudeMin;
    }
}