package com.sola.alittledemo.bean.resp;

/**
 * @author Sola
 * @date 2018/10/25
 */
public enum ResponseCodeEnum {

    OK(200, "成功"),

    INVALID_REQUEST(400, "请求不合法"),

    UNAUTHORIZED(401, "未授权");

    private Integer code;

    private String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

}
