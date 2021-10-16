package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("login")
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password){
        UserDTO userDTO = new UserDTO(username, password);
        Map<String, Object> result = new HashMap<>();
        result.put("data", userDTO);
        if (username.equals("admin") && password.equals("admin")) {
            result.put("status", "success");
        }else {
            result.put("status", "false");
        }
        return result;
    }
}
