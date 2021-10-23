package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.dto.PageDTO;
import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 用户 业务层实现类
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 1:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageDTO<UserEntity> getUserPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<UserEntity> userList = userDao.getAll();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(userList);
        return new PageDTO<>(page, limit, pageInfo.getTotal(), userList);
    }

    @Override
    public UserEntity login(UserDTO userDTO) {
        UserEntity userEntity = this.getByUserName(userDTO.getUsername());
        if (!ObjectUtils.isEmpty(userEntity) && userEntity.getPassword().equals(DigestUtils.md5DigestAsHex(userDTO.getPassword().getBytes()))) {
            return userEntity;
        }
        return null;
    }

    @Override
    public UserEntity getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public int addUser(String username, String password, Integer status) {
        return userDao.addUser(username, password, status);
    }

    @Override
    public int updateUserPassword(String username, String password) {
        return userDao.updateUserPassword(username, password);
    }

    @Override
    public List<UserEntity> findByUsername(String str) {
        return userDao.findByUsername(str);
    }
}
