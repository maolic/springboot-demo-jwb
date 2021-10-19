package com.example.springbootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP 切面
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/19 20:23
 */

@Slf4j
@Aspect
@Component
public class AopLog {

    /**
     * AOP通知类型
     * 1.前置通知
     * 2.后置通知
     * 3.环绕通知
     * 4.异常通知
     * 5.最终通知
     */

    @Before("execution(* com.example.springbootdemo.service.impl.UserServiceImpl.findByUsername(..))")
    public void listenGetAll() {
        log.info("【前置通知】开始查询用户");
    }

    @Around("execution(* com.example.springbootdemo.service.impl..*.*(..))")
    public Object printServiceRuntimes(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("【环绕通知】正在执行{}.{}", joinPoint.getTarget().getClass(), joinPoint.getTarget().getClass().getName());
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("【环绕通知】当前执行时间：{}ms", endTime - startTime);
        return result;
    }

    @After("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void listenGetAllEnd() {
        log.info("【后置通知】接收到用户Get请求");
    }
}
