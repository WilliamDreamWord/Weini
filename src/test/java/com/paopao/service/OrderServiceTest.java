package com.paopao.service;

import com.paopao.common.Const;
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
    public void shouldManageChangeOrderStatus() {
        orderService.manageChangeOrderStatus(119, Const.OrderStatusEnum.GET_ORDER.getCode());
    }

    @Test
    public void shouldSelectByDateStatus() {

        List<OrderManagerVo> orders = orderService.selectByDateStatusNow("2018-8-15",
                Const.OrderStatusEnum.GET_ORDER.getCode());
        System.out.println(orders);
    }

    @Test
    public void shouldSelectByPhone() {
        List<OrderManagerVo> orderVos = orderService.selectByPhone("1234567891123");
        System.out.println(orderVos);
    }

}
