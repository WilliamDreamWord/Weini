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


    public Shipping selectDefault(Integer userId) {
        List<Shipping> shippings = shippingMapper.selectByStatus(userId,
                Const.ShippingEnum.DEFAULT.getCode(), 0, 10);


        return CollectionUtils.isNotEmpty(shippings) ? shippings.get(0) : null;
    }




    private void updateStatus(Integer userId, Integer shippingId, Integer status) {
        int row = shippingMapper.updateStatus(userId, shippingId,status);
        Preconditions.checkArgument(row>0, "改变包裹状态失败");
    }



    public boolean changeToNormal(Integer userId, Integer shippingId) {
        updateStatus(userId, shippingId, Const.ShippingEnum.NORMAL.getCode());
        return true;
    }

    public boolean changeToDefault(Integer userId, Integer shippingId) {

        int row = shippingMapper.updateStatusByStatus(userId,
                Const.ShippingEnum.DEFAULT.getCode(), Const.ShippingEnum.NORMAL.getCode());

        Preconditions.checkArgument(row > 0, "更新状态失败");

        updateStatus(userId, shippingId, Const.ShippingEnum.DEFAULT.getCode());
        return true;
    }


    public Shipping add(ShippingParam shippingParam) {
        Shipping shipping = ShippingConvert.of(shippingParam);

        int row = 0;
        if (shippingParam.getStatus().equals(Const.ShippingEnum.DEFAULT.getCode())) {
            //如果添加的收货地址为默认时，会把其他默认地址改为normal
            row = shippingMapper.updateStatusByStatus(shippingParam.getUserId(),
                    Const.ShippingEnum.DEFAULT.getCode(), Const.ShippingEnum.NORMAL.getCode());

            Preconditions.checkArgument(row>0, "更新状态失败");

        }


        row = shippingMapper.insert(shipping);

        Preconditions.checkArgument(row>0, "新增地址失败");

        return shipping;
    }

    public void del(Integer userId, Integer shippingId) {
        int row = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        Preconditions.checkArgument(row>0, "删除地址失败");
    }




    public void update(Shipping shipping) {
        //如果传入的shipping为默认地址，那么要将其他默认地址变为正常的地址
        if (shipping.getStatus() != null &&
                shipping.getStatus().equals(Const.ShippingEnum.DEFAULT.getCode())) {
            int row = shippingMapper.updateStatusByStatus(shipping.getUserId(),
                    Const.ShippingEnum.DEFAULT.getCode(), Const.ShippingEnum.NORMAL.getCode());

            Preconditions.checkArgument(row > 0, "更新状态失败");
        }

        int row = shippingMapper.updateByShipping(shipping);
        Preconditions.checkArgument(row>0, "更新地址失败");
    }


    public Shipping select(Integer userId, Integer shippingId) {
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        Preconditions.checkNotNull(shipping, "无法查询到该地址");

        return shipping;
    }

    public List<Shipping> list(Integer userId, int pageNum, int pageSize) {
        List<Shipping> ans = shippingMapper.selectByStatus(userId, Const.ShippingEnum.DEFAULT.getCode(), 0, 10);
        List<Shipping> shippingList = shippingMapper.selectByStatus(userId,
                Const.ShippingEnum.NORMAL.getCode(),(pageNum-1)*pageSize,
                pageSize - ans.size());
        ans.addAll(shippingList);
        return ans;
    }


}
