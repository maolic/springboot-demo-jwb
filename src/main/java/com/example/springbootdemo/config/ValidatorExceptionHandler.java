package com.example.springbootdemo.config;

import com.example.springbootdemo.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/21 19:24
 */
@Slf4j
@ControllerAdvice // Controller增强器，通常用于（统一）异常处理
public class ValidatorExceptionHandler {

    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public Result<Object> validateExceptionHandler(ValidatorException e) {
        log.error(e.getMessage());
        return new Result<>().error(e.getMessage());
//        return new Result<>().error("请求参数异常");
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public Result<Object> duplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage());
//        return new Result<>().error(e.getMessage());
        return new Result<>().error("用户名重复，注册失败");
    }
}
