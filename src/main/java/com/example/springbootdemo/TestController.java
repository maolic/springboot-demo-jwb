package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试控制类
 * @author Shen && syf0412@vip.qq.com
 */

@Controller
public class TestController {

    @Value("${example.hello}")
    private String testValue;

    @GetMapping("test")
    @ResponseBody
    public String getTestValue(){
        return testValue;
    }

}
