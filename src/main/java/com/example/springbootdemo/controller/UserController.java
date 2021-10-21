package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.Result;
import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.service.UserService;
import com.example.springbootdemo.uitl.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户 控制层
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:53
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login") // http://localhost:8080/user/login?username=admin&password=password
    public Result<Object> login(@RequestParam("username") String username,
                                @RequestParam("password") String password){

        ValidatorUtil.require(username, "用户名");
        ValidatorUtil.require(password, "密码");

        UserDTO userDTO = userService.getByUserName(username);
        if (userDTO != null && userDTO.getPassword().equals(password)) {
            return new Result<>().ok();
        }else {
            return new Result<>().error("用户名密码错误");
        }
    }

    @PostMapping("register") // http://localhost:8080/user/register?username=admin1&password=password1
    public Result<Object> register(@RequestParam("username") String username,
                                   @RequestParam("password") String password){
        if (userService.addUser(username, password, 1) > 0) {
            UserDTO userDTO = userService.getByUserName(username);
            return new Result<>().ok("注册成功", userDTO);
        }else {
            return new Result<>().error("注册失败");
        }
    }

    @PostMapping("modifyPassword")
    public Result<Object> modifyPassword(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        if (userService.updateUserPassword(username, password) > 0) {
            return new Result<>().ok("修改成功");
        }else {
            return new Result<>().error("修改失败");
        }
    }

    // 根据用户名模糊查询
    @GetMapping("findByUsername")
    public Result<List<UserEntity>> findByUsername(@RequestParam("username") String username) {
        return new Result<List<UserEntity>>().ok(userService.findByUsername(username));
    }

}
