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
        ShippingParam shippingParam = new ShippingParam();
        shippingParam.setUserId(11);
        shippingParam.setReceiverLargeArea(" 252fae");
        shippingParam.setReceiverMediumArea("v rw");
        shippingParam.setReceiverSmallArea("dfwajlkfd");
        shippingParam.setReceiverDoor("q");
        shippingParam.setReceiverMobile("1234567891123");
        shippingParam.setReceiverName("oiioi");
        shippingParam.setStatus(Const.ShippingEnum.DEFAULT.getCode());
        Shipping shipping = shippingService.add(shippingParam);

        System.out.println(shipping.getId());
        Assert.assertTrue(shipping.getId() != null);
    }

    @Test
    public void shouldChangeToDefault() {
        boolean ans = shippingService.changeToDefault(11, 32);
        Assert.assertTrue(ans);
    }
}
