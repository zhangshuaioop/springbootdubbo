package com.baojufeng.commoncomponets.utils;


import com.baojufeng.commoncomponets.enums.ResultEnum;

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

    public static Result error(Integer code, String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        result.setEmsg(msg);
        return result;
    }
    public static Result error(Integer code, String msg,String emsg) {
        Result<Object> result = error(code,msg);
        result.setEmsg(emsg);
        return result;
    }
    public static Result validateError(String emsg) {
        Result<Object> result = new Result<Object>();
        result.setCode(120);
        result.setMsg(ResultEnum.PARAMTER_ERROR.getMsg());
        result.setEmsg(emsg);
        return result;
    }

}
