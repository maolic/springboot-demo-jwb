package com.example.springbootdemo.config;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一返回
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/23 13:30
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
     * 时间戳
     */
    private Long timeStamp = System.currentTimeMillis();
    /**
     * 响应数据
     */
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

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
