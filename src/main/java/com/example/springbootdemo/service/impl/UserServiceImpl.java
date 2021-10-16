package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.config.UserConfig;
import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 业务层实现类
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 1:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserConfig userConfig;

    @Override
    public Boolean checkUserLogin(UserDTO userDTO) {
        // 这里应当先去数据库查询用户
        UserEntity userDB = userConfig.getUser();
        // 对密码进行比较
        if (userDB.getUsername().equals(userDTO.getUsername()) && userDB.getPassword().equals(userDTO.getPassword())) {
            return true;
        }
        return false;
    }
}
