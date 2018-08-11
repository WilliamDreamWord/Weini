package com.paopao.dao;


import com.paopao.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectByPrimaryKey() {
        User ans = userMapper.selectByPrimaryKey(23);
        System.out.println(ans);
        Assert.assertEquals((int)ans.getId(), 23);

    }

    @Test
    public void testCheckUsername() {
        int ans = userMapper.checkUsername("test");
        Assert.assertEquals(ans, 1);
    }

}
