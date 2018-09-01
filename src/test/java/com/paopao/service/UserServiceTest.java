package com.paopao.service;

import com.paopao.param.LoginParam;
import com.paopao.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testFindByUsernamePassword() {

        long start = System.currentTimeMillis();

        LoginParam loginParam = new LoginParam();
        loginParam.setUsername("test");
        loginParam.setPassword("test");
        User user = userService.login(loginParam);

        System.out.println(user);

        System.out.println("expire: " + (System.currentTimeMillis() - start));


    }

}
