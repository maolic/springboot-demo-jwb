package com.example.springbootdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * Todolist实体类
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:47
 */
@Data
public class TodolistEntity {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String text;

}
