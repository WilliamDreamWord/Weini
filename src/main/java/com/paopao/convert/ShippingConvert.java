package com.paopao.convert;

import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import com.paopao.util.BeanValidator;

/**
 * Created by joker on 14/08/2018.
 */
public class ShippingConvert {

    public static Shipping of(ShippingParam shippingParam) {

        BeanValidator.check(shippingParam);

        Shipping shipping = new Shipping();
        shipping.setUserId(shippingParam.getUserId());
        shipping.setReceiverName(shippingParam.getReceiverName());
        shipping.setReceiverMobile(shippingParam.getReceiverMobile());
        shipping.setReceiverLargeArea(shippingParam.getReceiverLargeArea());
        shipping.setReceiverMediumArea(shippingParam.getReceiverMediumArea());
        shipping.setReceiverSmallArea(shippingParam.getReceiverSmallArea());
        shipping.setReceiverDoor(shippingParam.getReceiverDoor());

        return shipping;
    }

}
