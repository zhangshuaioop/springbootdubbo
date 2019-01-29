package com.teekee.blackrockservice.utils;

/**
 * Created by ray on 2017/1/5.
 */
public class ResponseMessage {
    private boolean status;
    private String code;
    private String message;
    private Object temp;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getTemp() {
        return temp;
    }

    public void setTemp(Object temp) {
        this.temp = temp;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(boolean status, String code, String message) {
        this.setStatus(status);
        this.setCode(code);
        this.setMessage(message);
    }

    public void setTemp(boolean status, String code, String message, Object temp) {
        this.setStatus(status);
        this.setCode(code);
        this.setMessage(message);
        this.setTemp(temp);
    }

    //@Override
    //public String toString() {
    //    String json = "{\"data\":" + DataFormatTransform.changeModel2Json(data)+ ",\"status\":" +status + ",\"message\":'"+message+ "',\"code\":" +code+"}";
    //    return json;
    //}
}
