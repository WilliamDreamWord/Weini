package com.paopao.dao;

import com.paopao.po.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    Order selectByOrderNo(Long OrderNo);

    List<Order> selectByUserId(@Param("userId") Integer userId, @Param("begin") int begin,
                               @Param("offset") int offset);


    List<Order> selectAllOrder(@Param("begin")int begin, @Param("offset") int num);

    int closeOrderByOrderId(Integer id);


}