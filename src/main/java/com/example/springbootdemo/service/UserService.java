package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * 用户 业务层
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 1:15
 */
public interface UserService {

    Boolean checkUserLogin(UserDTO userDTO);

    UserEntity getByUserId(Long id);

}
