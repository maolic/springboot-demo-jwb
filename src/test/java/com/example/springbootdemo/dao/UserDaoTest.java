package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * User 测试类
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 14:18
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void getAll() {
        List<UserEntity> allUser = userDao.getAll();
        log.info(String.valueOf(allUser));
        Assert.assertNotNull(allUser);
    }

}