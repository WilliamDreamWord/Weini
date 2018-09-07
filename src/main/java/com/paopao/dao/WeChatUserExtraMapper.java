package com.paopao.dao;

import com.paopao.po.WeChatUserExtra;

public interface WeChatUserExtraMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatUserExtra record);

    int insertSelective(WeChatUserExtra record);

    WeChatUserExtra selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatUserExtra record);

    int updateByPrimaryKey(WeChatUserExtra record);



    WeChatUserExtra selectByUserId(Integer userId);

    Integer selectOrderCountByUserId(Integer userId);

    int incrOrderCount(Integer userId);


}