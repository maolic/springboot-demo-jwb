package com.example.springbootdemo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

}
