package com.paopao.dao;

import com.paopao.po.OrderShipping;

public interface OrderShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);

    OrderShipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderShipping record);

    int updateByPrimaryKey(OrderShipping record);
}