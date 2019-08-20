package com.agan.springboot.springbootdemo.controller;

import com.agan.springboot.springbootdemo.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: yeting
 * @Date: 2019/8/16 10:25
 */
@RestController
public class HelloWordController {

    //获取自定义变量,该变量直接从配置文件yml中获取相应得变量
//    @Value("${agan.msg}")
//    private String msg;


    @RequestMapping("/hello")
    public String index() {
        //测试全局所有异常的捕获和处理
//        int no = 1 / 0;

        throw new BusinessException("100", "用户密码错误！");
//        return this.msg;
    }
}
