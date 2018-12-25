package com.platform.springboot.entity.dmi;

/**
 * @author Wujun
 * @create 2017年11月28日 16:07
 */
public class DmiEmployeeUniqueness {

    private int row;
    private String fieldName;
    private String fieldValue;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
