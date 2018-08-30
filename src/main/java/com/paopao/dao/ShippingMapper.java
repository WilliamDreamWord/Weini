package com.paopao.dao;

import com.paopao.po.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);


    int deleteByShippingIdUserId(@Param("userId")Integer userId,
                                 @Param("shippingId") Integer shippingId);

    int updateByShipping(Shipping shipping);


    Shipping selectByShippingIdUserId(@Param("userId")Integer userId,
                                      @Param("shippingId") Integer shippingId);

    List<Shipping> selectByUserId(@Param("userId")Integer userId, @Param("begin") int begin,
                                  @Param("count") int count);

    int updateStatus(@Param("userId") Integer userId,@Param("shppingId") Integer shippingId,
                     @Param("status") Integer status);

    List<Shipping> selectByStatus(@Param("userId") Integer userId, @Param("status") Integer status,
                                  @Param("begin") Integer begin, @Param("count") Integer count);
}