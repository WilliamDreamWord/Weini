package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.convert.ShippingConvert;
import com.paopao.dao.ShippingMapper;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by joker on 13/08/2018.
 */
@Service
public class ShippingService {

    @Autowired
    private ShippingMapper shippingMapper;


    public Shipping add(ShippingParam shippingParam) {
        Shipping shipping = ShippingConvert.of(shippingParam);
        int row = shippingMapper.insert(shipping);
        Preconditions.checkArgument(row>0, "新增地址失败");

        return shipping;
    }

    public void del(Integer userId, Integer shippingId) {
        int row = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        Preconditions.checkArgument(row>0, "删除地址失败");
    }


    public void update(Integer shippingId, ShippingParam shippingParam) {
        Shipping shipping = ShippingConvert.of(shippingParam);
        shipping.setId(shippingId);

        int row = shippingMapper.updateByShipping(shipping);
        Preconditions.checkArgument(row>0, "更新地址失败");
    }


    public Shipping select(Integer userId, Integer shippingId) {
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        Preconditions.checkNotNull(shipping, "无法查询到该地址");

        return shipping;
    }

    public List<Shipping> list(Integer userId, int pageNum, int pageSize) {
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId, (pageNum-1)*pageSize, pageSize);
        return shippingList;
    }


}
