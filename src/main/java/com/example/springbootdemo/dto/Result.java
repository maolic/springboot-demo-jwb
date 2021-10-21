package com.example.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一返回DTO
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/21 9:22
 */
public class Result<T> {
    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 0;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL) // 对值为null时不返回此属性
    private T data;

    public Result<T> ok() {
        return this;
    }

    public Result<T> ok(String msg) {
        this.setMsg(msg);
        return this;
    }

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public Result<T> ok(String msg, T data) {
        this.setMsg(msg);
        this.setData(data);
        return this;
    }

    public Result<T> error(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
