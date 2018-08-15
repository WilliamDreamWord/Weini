package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.convert.ShippingConvert;
import com.paopao.dao.ShippingMapper;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joker on 13/08/2018.
 */
@Service
public class ShippingService {

    @Autowired
    private ShippingMapper shippingMapper;


    public Map<String, Integer> add(ShippingParam shippingParam) {
        Shipping shipping = ShippingConvert.of(shippingParam);
        int row = shippingMapper.insert(shipping);
        Preconditions.checkArgument(row>0, "新增地址失败");

        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());

        return map;
    }

    public void del(Integer userId, Integer shippingId) {
        int row = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        Preconditions.checkArgument(row>0, "删除地址失败");
    }


    public void update(Shipping shipping) {
        //userId在这里是为了防止横向越权
        Preconditions.checkNotNull(shipping.getId(), "请输入订单id");
        Preconditions.checkNotNull(shipping.getUserId(), "请输入用户id");

        int row = shippingMapper.updateByPrimaryKeySelective(shipping);
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
