package com.example.springbootdemo.controller;

import com.example.springbootdemo.config.Result;
import com.example.springbootdemo.dao.TodolistDao;
import com.example.springbootdemo.entity.TodolistEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/23 15:45
 */
@RestController
@RequestMapping("todolist")
public class TodolistController {
    @Resource
    private TodolistDao todolistDao;
    @ApiOperation("全部")
    @GetMapping("all")
    public Result<Object> all(){
        return new Result<>().ok(todolistDao.all());
    }
    @ApiOperation("增")
    @PostMapping("add")
    public Result<Object> add(@RequestParam("text") String text){
        if (todolistDao.add(text) > 0) {
            return new Result<>().ok();
        }
        return new Result<>().error("error");
    }
    @ApiOperation("删")
    @PostMapping("delete")
    public Result<Object> delete(@RequestParam("id") Long id){
        if (todolistDao.delete(id) > 0) {
            return new Result<>().ok();
        }
        return new Result<>().error("error");
    }
    @ApiOperation("改")
    @PostMapping("update")
    public Result<Object> update(@RequestBody TodolistEntity todolistEntity){
        if (todolistDao.update(todolistEntity.getId(), todolistEntity.getText()) > 0) {
            return new Result<>().ok();
        }
        return new Result<>().error("error");
    }
    @ApiOperation("查 - 等于")
    @GetMapping("equal")
    public Result<Object> equal(@RequestParam("text") String text){
        return new Result<>().ok(todolistDao.equal(text));
    }
    @ApiOperation("查 - 模糊查询")
    @GetMapping("like")
    public Result<Object> like(@RequestParam("text") String text){
        return new Result<>().ok(todolistDao.like(text));
    }
}
