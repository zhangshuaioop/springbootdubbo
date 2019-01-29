package com.teekee.blackrockservice.utils;


import com.teekee.blackrockservice.config.ResponseMessageConfig;

/**
 * @author Wujun
 * @create 2017年08月31日 13:35
 */
public class StringUtil {

    /**
     * 构造新增成功的返回信息
     *
     * @return
     */
    public static final ResponseMessage buildInsertSuccessRespMsg() {
        return buildSuccessRespMsg(ResponseMessageConfig.INSERT_SUCCESS);
    }

    /**
     * 构造更新成功的返回信息
     *
     * @return
     */
    public static final ResponseMessage buildUpdateSuccessRespMsg() {
        return buildSuccessRespMsg(ResponseMessageConfig.UPDATE_SUCCESS);
    }

    /**
     * 构造失效成功的返回信息
     *
     * @return
     */
    public static final ResponseMessage buildInvalidSuccessRespMsg() {
        return buildSuccessRespMsg(ResponseMessageConfig.INVALID_SUCCESS);
    }

    /**
     * 构造删除成功的返回信息
     *
     * @return
     */
    public static final ResponseMessage buildDeleteSuccessRespMsg() {
        return buildSuccessRespMsg(ResponseMessageConfig.DELETE_SUCCESS);
    }

    /**
     * 构造成功的返回信息
     *
     * @param msg
     * @return
     */
    public static final ResponseMessage buildSuccessRespMsg(final String msg) {
        ResponseMessage result = new ResponseMessage();
        result.setStatus(true);
        result.setCode(ResponseMessageConfig.COMMON_SUCCESS_CODE);
        result.setData(null);
        result.setMessage(msg);
        return result;
    }

    /**
     * 构造成功的临时返回信息
     *
     * @param msg
     * @param temp
     * @return
     */
    public static final ResponseMessage buildSuccessRespTempMsg(final String msg, final Object temp) {
        ResponseMessage result = new ResponseMessage();
        result.setStatus(true);
        result.setCode(ResponseMessageConfig.COMMON_SUCCESS_CODE);
        result.setTemp(temp);
        result.setData(null);
        result.setMessage(msg);
        return result;
    }

    /**
     * 构造失败的返回信息
     *
     * @param msg
     * @return
     */
    public static ResponseMessage buildErrorRespMsg(final String msg) {
        ResponseMessage result = new ResponseMessage();
        result.setStatus(false);
        result.setCode(ResponseMessageConfig.COMMON_FAILURE_CODE);
        result.setData(null);
        result.setMessage(msg);
        return result;
    }

    /**
     * 构造非法请求的返回信息
     *
     * @return
     */
    public static ResponseMessage buildIllegalRespMsg() {
        ResponseMessage result = new ResponseMessage();
        result.setStatus(false);
        result.setCode(ResponseMessageConfig.ILLEGAL_REQUEST_CODE);
        result.setData(null);
        result.setMessage(ResponseMessageConfig.ILLEGAL_REQUEST);
        return result;
    }

    /**
     * 构造警告的返回信息
     *
     * @param msg
     * @return
     */
    public static ResponseMessage buildWarnRespMsg(final String msg) {
        ResponseMessage result = new ResponseMessage();
        result.setStatus(false);
        result.setCode("999");
        result.setData(null);
        result.setMessage(msg);
        return result;
    }
    /**
     * 构造json的返回成功信息
     *
     * @param data
     * @return
     */
    public static ResponseMessage buildJsonSucessRespMsg(final Object data) {
        ResponseMessage result = new ResponseMessage();
        result.setStatus(true);
        result.setCode(ResponseMessageConfig.COMMON_SUCCESS_CODE);
        result.setData(data);
        result.setMessage("");
        return result;
    }
}
