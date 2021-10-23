package com.example.springbootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局控制层异常拦截
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/23 14:32
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(BindException.class)
    public Result<Object> bindException(BindException e) {
        log.error(e.getMessage());
        return new Result<>().error(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        return new Result<>().error(collect.toString());
//        log.error(e.getMessage());
//        return new Result<>().error("请求参数异常");
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage());
        return new Result<>().error("请求方法异常");
    }
    @ExceptionHandler(Exception.class)
    public Result<Object> exception(Exception e) {
        log.error(e.getMessage());
        return new Result<>().error("请求异常");
    }
}
