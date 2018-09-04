package com.paopao.dao;

import com.paopao.po.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int updateByOrderNo(Order record);

    Order selectByUserIdAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    Order selectByOrderNo(Long OrderNo);

    List<Order> selectByUserId(@Param("userId") Integer userId, @Param("begin") int begin,
                               @Param("offset") int offset);


    List<Order> selectAllOrder(@Param("begin")int begin, @Param("offset") int num);

    int closeOrderByOrderId(Integer id);

    int countAll();

    int countByUserIdStatus(@Param("userId") Integer userId, @Param("status") Integer status);


    List<Order> selectByUserIdDateStatus(@Param("begin")Date begin,
                                         @Param("end") Date end,
                                         @Param("status") Integer status);


    List<Order> selectByShippingIds(@Param("shippingIdList") List<Integer> shippingIdList);

    List<Order> selectByShippingId(Integer shippingId);

    int deleteByOrderNo(Long orderNo);




}