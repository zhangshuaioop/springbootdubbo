package com.example.messenger.enums;

public enum ResultEnum {
    UNKONW_ERROR(500, "服务器内部错误！"),
    SUCCESS(0, "成功"),
    PARAMTER_ERROR(200, "参数格式检验失败！"),
    SIGN_ERROR(202, "参数签名校验失败！"),
    DUPLICATE_USER_NAME(102, "用户名已存在"),
    USER_NOT_EXSTIS(204, "用户信息不存在"),
    SEND_EMAIL_ERROR(251, "发送失败"),
    MICRO_SERVICE_ERROR(1001, "Micro服务异常！"),
    SEND_MQ_ERROR(252, "MQ消息发送失败"),;

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
