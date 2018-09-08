package com.paopao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by joker on 08/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatUserExtraMapperTest {


    @Autowired
    private WeChatUserExtraMapper weChatUserExtraMapper;

    @Test
    public void should() {
        System.out.println(weChatUserExtraMapper.selectOrderCountByUserId(37));
    }

}
