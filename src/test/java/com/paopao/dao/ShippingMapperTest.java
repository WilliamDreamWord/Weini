package com.paopao.dao;

import com.paopao.common.Const;
import com.paopao.po.Shipping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by joker on 04/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingMapperTest {

    @Autowired
    private ShippingMapper shippingMapper;


    @Test
    public void shouldSelectByStatus() {
        List<Shipping> shippings = shippingMapper.selectByStatus(11,
                Const.ShippingEnum.NORMAL.getCode(), 0, 10);

        System.out.println(shippings);
        System.out.println();
        System.out.println(shippings.size());
    }
}
