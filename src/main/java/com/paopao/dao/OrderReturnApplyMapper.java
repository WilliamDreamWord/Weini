package com.paopao.dao;

import com.paopao.po.OrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderReturnApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderReturnApply record);

    int insertSelective(OrderReturnApply record);

    OrderReturnApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderReturnApply record);

    int updateByPrimaryKey(OrderReturnApply record);

    List<OrderReturnApply> list(@Param("auditStatus") Integer auditStatus,
                                @Param("begin") Integer begin,
                                @Param("count") Integer count);





}