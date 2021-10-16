package com.example.springbootdemo.dto;

import lombok.Data;

/**
 * 用户DTO
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:52
 */
@Data
public class UserDTO {
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

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
