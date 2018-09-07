package com.paopao.service;

import com.paopao.common.Const;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by joker on 30/08/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingServiceTest {

    @Autowired
    private ShippingService shippingService;

    @Test
    public void shouldAdd() {
        long start = System.currentTimeMillis();

        ShippingParam shippingParam = new ShippingParam();
        shippingParam.setUserId(23);
        shippingParam.setReceiverLargeArea("mmp");
        shippingParam.setReceiverMediumArea("mmp");
        shippingParam.setReceiverSmallArea("mmp");
        shippingParam.setReceiverDoor("mmp");
        shippingParam.setReceiverMobile("mmp");
        shippingParam.setReceiverName("mmp");
        shippingParam.setStatus(Const.ShippingEnum.DEFAULT.getCode());
        Shipping shipping = shippingService.add(shippingParam);

        System.out.println("expire: " + (System.currentTimeMillis() - start));

        System.out.println(shipping.getId());
        Assert.assertTrue(shipping.getId() != null);
    }

    @Test
    public void shouldChangeToDefault() {
        long start = System.currentTimeMillis();
        boolean ans = shippingService.changeToDefault(23, 42);

        System.out.println("expire: " + (System.currentTimeMillis() - start));

        Assert.assertTrue(ans);
    }

    @Test
    public void shouldUpdate() {
        long start = System.currentTimeMillis();

        Shipping shipping = new Shipping();
        shipping.setId(41);
        shipping.setUserId(23);
        shipping.setStatus(Const.ShippingEnum.DEFAULT.getCode());
        shipping.setReceiverName("吃吃吃");
        shippingService.update(shipping);

        System.out.println("expire: " + (System.currentTimeMillis() - start));

    }

    @Test
    public void shouldGetDefault() {
        System.out.println(shippingService.selectDefault(31324));

    }
}
