package com.agan.springboot.springbootdemo.exception;

/**
 * 自定义异常
 *
 * @Author: yeting
 * @Date: 2019/8/17 8:17
 */
public class BusinessException extends RuntimeException {

    private String code;

    private String msg;

    public BusinessException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
