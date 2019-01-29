package com.teekee.messengerservice.enums;

/**
 * 业务码
 */
public enum BusinessEnum {

    EMAIL(111, "email"),
    SMS(112, "sms");
    private Integer code;

    private String type;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    BusinessEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
