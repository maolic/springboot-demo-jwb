package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.PageDTO;
import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;

import java.util.List;

/**
 * 用户 业务层
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 1:15
 */
public interface UserService {

    /**
     * 获取所有用户
     * @return 用户列表
     */
    PageDTO<UserEntity> getUserPage(Integer page, Integer limit);

    /**
     * 登录
     * @param userDTO 用户信息
     * @return 用户
     */
    UserEntity login(UserDTO userDTO);

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 用户
     */
    UserEntity getByUserName(String username);

    /**
     * 新增用户
     * @param username 用户名
     * @param password 密码
     * @param status 状态
     * @return 成功执行行数
     */
    int addUser(String username, String password, Integer status);

    /**
     * 更新用户密码
     * @param username 用户名
     * @param password 新密码
     * @return 成功执行行数
     */
    int updateUserPassword(String username, String password);

    /**
     * 根据用户名模糊查询
     * @param str 用户名
     * @return 用户列表
     */
    List<UserEntity> findByUsername(String str);

}
