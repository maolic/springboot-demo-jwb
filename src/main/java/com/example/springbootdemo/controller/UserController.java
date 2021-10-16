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
        UserDTO userDTO = new UserDTO(username, password);
        Map<String, Object> result = new HashMap<>();
        result.put("data", userDTO);
        if (userService.checkUserLogin(userDTO)) {
            result.put("status", "success");
        }else {
            result.put("status", "false");
        }
        return result;
    }

    @GetMapping("getByUserId/{id}") // http://localhost:8080/user/getByUserId/1
    public Map<String, Object> getByUserId(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        UserEntity userEntity = userService.getByUserId(id);
        result.put("status", "success");
        result.put("data", userEntity);
        return result;
    }
}
