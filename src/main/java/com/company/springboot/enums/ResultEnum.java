package com.company.springboot.enums;

public enum ResultEnum {
    UNKONW_ERROR(500, "服务器内部错误！"),
    SUCCESS(200, "成功"),
    PARAMTER_ERROR(201, "参数错误！"),
    SIGN_ERROR(202, "参数签名校验失败！"),
    DUPLICATE_USER_NAME(102, "用户名已存在"),
    USER_NOT_EXSTIS(204, "用户信息不存在"),
    SEND_EMAIL_ERROR(251, "发送邮箱失败"),
    SEND_SMS_ERROR(252, "发送短信失败"),
    MICRO_SERVICE_ERROR(1001, "Micro服务异常！"),
    JEDIS_LOCK_UP(1108,"redis加锁失败"),
    EXCEPTION(406,"服务异常"),
    ERROR_BUSINESS(205,"业务失败"),
    UPLOAD_MODEL_TYPE_FAILURE(502,"文件上传失败，原因是：不支持上传该文件类型或上传的模块不存在"),
    SEND_MQ_ERROR(252, "MQ消息发送失败,开始进行补发操作"),;
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
