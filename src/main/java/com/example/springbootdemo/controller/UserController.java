package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户 控制层
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 0:53
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("login") // http://localhost:8080/user/login?username=admin&password=password
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password){
        Map<String, Object> result = new HashMap<>();
        UserEntity userEntity = userService.getByUserName(username);
        if (userEntity != null && userEntity.getPassword().equals(password)) {
            result.put("status", "success");
            userEntity.setPassword(null);
            result.put("data", userEntity);
        }else {
            result.put("status", "false");
            result.put("data", "用户名或密码错误");
        }
        return result;
    }

    @PostMapping("register") // http://localhost:8080/user/register?username=admin1&password=password1
    public Map<String, Object> register(@RequestParam("username") String username,
                                        @RequestParam("password") String password){
        Map<String, Object> result = new HashMap<>();
        if (userService.addUser(username, password, 1) > 0) {
            result.put("status", "success");
            result.put("data", "注册成功");
        }else {
            result.put("status", "false");
            result.put("data", "注册失败");
        }
        return result;
    }

}
