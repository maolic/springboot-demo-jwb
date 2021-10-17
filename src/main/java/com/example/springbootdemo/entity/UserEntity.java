package com.example.springbootdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:47
 */
@Data
public class UserEntity {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
