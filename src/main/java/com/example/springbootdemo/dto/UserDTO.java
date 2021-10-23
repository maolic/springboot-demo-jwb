package com.example.springbootdemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户DTO
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:52
 */
@ApiModel("用户")
@Data
public class UserDTO {
    /**
     * id
     */
    @ApiModelProperty("用户ID")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

}
