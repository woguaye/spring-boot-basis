package com.agan.springboot.springbootdemo;

import com.agan.springboot.springbootdemo.service.Demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Test
    public void contextLoads() {
        int sum = Demo.getSum(1, 2);
        System.out.println(sum);
    }

}
