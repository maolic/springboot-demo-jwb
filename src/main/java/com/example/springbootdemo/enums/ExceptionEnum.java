package com.example.springbootdemo.enums;

/**
 * 登录返回值枚举类
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/23 14:24
 */
public enum ExceptionEnum {
    LOGIN_ERROR(1401, "用户名或密码错误");
    ;
    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static ExceptionEnum getByCode(int code) {
        for (ExceptionEnum value : ExceptionEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
