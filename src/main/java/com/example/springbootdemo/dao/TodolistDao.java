package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.TodolistEntity;
import com.example.springbootdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Todolist Dao
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 14:01
 */
@Mapper
public interface TodolistDao {

    int add(String text);

    int delete(Long id);

    int update(Long id, String text);

    List<TodolistEntity> equal(String text);

    List<TodolistEntity> like(String text);

    List<TodolistEntity> all();
}
