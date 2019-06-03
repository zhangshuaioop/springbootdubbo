package com.help.helpme.utils;


import com.help.helpme.enums.ResultEnum;

public class ResultUtil {
    public static Result success(Object object) {
        Result<Object> result = new Result<Object>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }


    public static Result success(Integer code, String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    /**
     * 业务失败
     * @param msg
     * @return
     */
    public static Result errorBusinessMsg(String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(ResultEnum.ERROR_BUSINESS.getCode());
        if(msg != null && msg.length()>0){
            result.setMsg(msg);
        }else {
            result.setMsg(ResultEnum.ERROR_BUSINESS.getMsg());
        }
        return result;
    }


    /**
     * 异常消息 自定义
     * @param msg
     * @return
     */
    public static Result errorExceptionMsg(String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(ResultEnum.EXCEPTION.getCode());
        if(msg != null && msg.length()>0){
            result.setMsg(msg);
        }else {
            result.setMsg(ResultEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 参数校验 自定义内容
     * @param msg
     * @return
     */
    public static Result validateError(String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(ResultEnum.PARAMTER_ERROR.getCode());
        if(msg != null && msg.length()>0){
            result.setMsg(msg);
        }else {
            result.setMsg(ResultEnum.PARAMTER_ERROR.getMsg());
        }
        return result;
    }


    /**
     * 成功消息 自定义
     * @param msg
     * @return
     */
    public static Result  successMsg(String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        if(msg != null && msg.length()>0){
            result.setMsg(msg);
        }else {
            result.setMsg(ResultEnum.SUCCESS.getMsg());
        }
        return result;
    }

    /**
     * 权限不足
     * @return
     */
    public static Result JurisdictionError(String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(ResultEnum.USER_NOT_EXSTIS.getCode());
        if(msg != null && msg.length()>0){
            result.setMsg(msg);
        }else {
            result.setMsg(ResultEnum.USER_NOT_EXSTIS.getMsg());
        }
        return result;
    }

}
