package com.example.timemachine.enums;

public enum ResultEnum {
    UNKONW_ERROR(500, "服务器内部错误！"),
    SUCCESS(0, "成功"),
    PARAMTER_ERROR(200, "参数格式检验失败！"),
    SIGN_ERROR(202, "参数签名校验失败！"),
    DUPLICATE_USER_NAME(102, "用户名已存在"),
    USER_NOT_EXSTIS(204, "用户信息不存在"),
    MICRO_SERVICE_ERROR(1001, "MicroService服务异常！"),;
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }
}
