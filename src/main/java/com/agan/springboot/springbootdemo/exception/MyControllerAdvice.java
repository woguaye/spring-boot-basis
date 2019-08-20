package com.agan.springboot.springbootdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yeting
 * @Date: 2019/8/16 20:57
 */
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局捕获异常：只要作用在@RequestMapping方法上，所有的异常信息都会被捕获
     * 全局捕获所有异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception ex) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", ex.getMessage());
        return map;
    }

    /**
     * 对自定义异常进行捕获和处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Map<String, Object> errorHandler(BusinessException ex) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        return map;
    }
}
