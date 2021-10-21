package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserEntity> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserDTO getByUserName(String username) {
        UserEntity userEntity = userDao.getByUserName(username);
        if (userEntity == null) {
            return null;
        }else {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        }
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
