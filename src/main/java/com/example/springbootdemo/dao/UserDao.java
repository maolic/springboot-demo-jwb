package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户 Dao
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 14:01
 */
@Mapper
public interface UserDao {

    List<UserEntity> getAll();
}
