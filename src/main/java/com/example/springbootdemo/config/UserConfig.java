package com.example.springbootdemo.config;

import com.example.springbootdemo.entity.UserEntity;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户 配置类
 * 这里没有配置数据库连接，暂时使用配置类的方法设置一个用户
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 1:07
 */
@Configuration
public class UserConfig {
    @Bean
    @SneakyThrows // 对异常处理，直接抛出异常
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("admin");
        userEntity.setPassword("password");
        userEntity.setStatus(1);
        userEntity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-10-17 13:41:07"));
        userEntity.setUpdateTime(new Date());
        return userEntity;
    }
}
