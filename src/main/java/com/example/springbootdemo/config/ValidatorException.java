package com.example.springbootdemo.config;

/**
 * 自定义异常
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/21 19:19
 */
public class ValidatorException extends RuntimeException {
    public ValidatorException(String message) {
        super(message);
    }
}
