package com.paopao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by joker on 28/08/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PackageMapperTest {

    @Autowired
    private PackageMapper packageMapper;

    @Test
    public void shouldSelect() {
        System.out.println(packageMapper.selectByPrimaryKey(31));
    }

}
