package com.example.springbootdemo.controller;

import com.example.springbootdemo.config.Result;
import com.example.springbootdemo.dto.PageDTO;
import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.enums.ExceptionEnum;
import com.example.springbootdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户 控制层
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:53
 */
@Api("用户")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户list
     * http://localhost:8080/user/list
     */
    @ApiOperation("查询用户分页")
    @GetMapping("list")
    public Result<PageDTO<UserEntity>> list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                             @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        PageDTO<UserEntity> userPage = userService.getUserPage(page, limit);
        return new Result<PageDTO<UserEntity>>().ok(userPage);
    }

    /**
     * 登录
     * http://localhost:8080/user/login?username=admin&password=password
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public Result<Object> login(@Valid @RequestBody UserDTO userDTO){
        UserEntity user = userService.login(userDTO);
        if (!ObjectUtils.isEmpty(user)) {
            return new Result<>().ok("登陆成功");
        }
        return new Result<>().error(ExceptionEnum.LOGIN_ERROR.getMsg());
    }

    /**
     * 注册
     * http://localhost:8080/user/register?username=admin1&password=password1
     */
    @ApiOperation("注册")
    @PostMapping("register")
    public Result<Object> register(@Valid @RequestBody UserDTO userDTO){
        if (ObjectUtils.isEmpty(userService.getByUserName(userDTO.getUsername()))) {
            userService.addUser(userDTO.getUsername(), DigestUtils.md5DigestAsHex(userDTO.getPassword().getBytes()), 1);
            return new Result<>().ok("注册成功");
        }else {
            return new Result<>().error("用户名已被注册");
        }
    }

    @ApiOperation("修改密码")
    @PostMapping("modifyPassword")
    public Result<Object> modifyPassword(@Valid @RequestBody UserDTO userDTO) {
        if (userService.updateUserPassword(userDTO.getUsername(), DigestUtils.md5DigestAsHex(userDTO.getPassword().getBytes())) > 0) {
            return new Result<>().ok("修改成功");
        }
        return new Result<>().error("请检查提交信息");
    }

    @ApiOperation("根据用户名模糊查询")
    @GetMapping("findByUsername")
    public Result<Object> findByUsername(@RequestParam("username") String username) {
        return new Result<>().ok(userService.findByUsername(username));
    }

}
