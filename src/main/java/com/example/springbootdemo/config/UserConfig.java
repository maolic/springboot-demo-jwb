package com.example.springbootdemo.config;

import com.example.springbootdemo.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 用户 配置类
 * 这里没有配置数据库连接，暂时使用配置类的方法设置一个用户
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 1:07
 */
@Configuration
public class UserConfig {
    @Bean
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("admin");
        userEntity.setPassword("password");
        userEntity.setStatus(1);
        userEntity.setCreateTime(LocalDateTime.parse("2021-10-17 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userEntity.setUpdateTime(LocalDateTime.now());
        return userEntity;
    }
}
