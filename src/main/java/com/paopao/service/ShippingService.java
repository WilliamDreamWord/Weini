package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.convert.ShippingConvert;
import com.paopao.dao.ShippingMapper;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import org.apache.commons.collections4.CollectionUtils;
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


    public List<Shipping> selectByStatus(Integer userId, Integer status) {
        List<Shipping> shippings = shippingMapper.selectByStatus(userId, status);
        return shippings;
    }


    private void updateStatus(Integer userId, Integer shippingId, Integer status) {
        int row = shippingMapper.updateStatus(userId, shippingId,status);
        Preconditions.checkArgument(row>0, "改变包裹状态失败");
    }



    public boolean changeToNormal(Integer userId, Integer shippingId) {
        updateStatus(userId, shippingId, Const.ShippingEnum.NORMAL.getCode());
        return true;
    }

    public boolean changeTodefault(Integer userId, Integer shippingId) {
        List<Shipping> shippings = selectByStatus(userId, Const.ShippingEnum.DEFAULT.getCode());
        if (CollectionUtils.isNotEmpty(shippings)) {
            return false;
        }
        updateStatus(userId, shippingId, Const.ShippingEnum.DEFAULT.getCode());
        return true;
    }


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
