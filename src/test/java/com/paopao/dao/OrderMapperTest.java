package com.paopao.dao;

import com.paopao.po.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test() {
        Calendar begin = new GregorianCalendar(2018, 8-1, 1);
        Calendar end = new GregorianCalendar(2018, 8-1, 31);


        List<Order> orderList = orderMapper.selectByUserIdDateStatus(23,
                begin.getTime(),
                end.getTime(),
                null);

        System.out.println(orderList);
    }


}
