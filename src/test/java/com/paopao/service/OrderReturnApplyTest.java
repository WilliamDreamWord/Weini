package com.paopao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by joker on 06/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderReturnApplyTest {


    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    @Test
    public void shouldAddApply() {
        orderReturnApplyService.add(23, 1536240646692L, "too long 妈妈陪");

    }

    @Test
    public void shouldRefuse() {
        orderReturnApplyService.refuse(5, "just refuse", null);
    }

    @Test
    public void shouldPass() {
        orderReturnApplyService.pass(5, "just pass", "something");
    }


    @Test
    public void shouldList() {
        System.out.println(orderReturnApplyService.list(null, 1, 11));

        System.out.println("=====================================");
        System.out.println(orderReturnApplyService.list(1, 1, 11));


        System.out.println("=====================================");
        System.out.println(orderReturnApplyService.list(-1, 1, 11));


        System.out.println("=====================================");
        System.out.println(orderReturnApplyService.selectById(5));
    }

}
