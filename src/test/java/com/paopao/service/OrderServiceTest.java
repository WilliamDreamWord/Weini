package com.paopao.service;

import com.paopao.common.OrderConst;
import com.paopao.vo.OrderManagerVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by joker on 02/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;


    @Test
    public void shouldAdd() {
        orderService.addOrder(38, 41, 23);
    }

    @Test
    public void shouldDetail() {
        System.out.println(orderService.manageDetail(1536240646692L));
    }

    @Test
    public void shouldManageChangeOrderStatus() {
        orderService.manageChangeOrderStatus(1534329381721L, OrderConst.OrderStatusEnum.CANCELED.getCode());
    }

    @Test
    public void shouldSelectByDateStatus() {

        List<OrderManagerVo> orders = orderService.selectByDateStatusNow("2018-8-15",
                OrderConst.OrderStatusEnum.GET_ORDER.getCode());
        System.out.println(orders);
    }


}
