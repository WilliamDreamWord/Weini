package com.paopao.dao;

import com.paopao.po.WeChatUser;

public interface WeChatUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatUser record);

    int insertSelective(WeChatUser record);

    WeChatUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatUser record);

    int updateByPrimaryKey(WeChatUser record);
}