package com.example.springbootdemo.uitl;


import com.example.springbootdemo.config.ValidatorException;
import org.springframework.util.StringUtils;

/**
 * 参数校验
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/21 19:57
 */
public class ValidatorUtil {

    /**
     * 校验str是否为空
     */
    public static void require(String str, String attrName) {
        if (str == null || str.length() == 0) { // StringUtils.hasText(str)
            throw new ValidatorException(attrName + "不能为空");
        }
    }
}
