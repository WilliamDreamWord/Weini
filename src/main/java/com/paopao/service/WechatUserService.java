package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.dao.WeChatUserExtraMapper;
import com.paopao.dao.WeChatUserMapper;
import com.paopao.po.WeChatUser;
import com.paopao.po.WeChatUserExtra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joker on 12/08/2018.
 */
@Service
@PropertySource("classpath:wechat.properties")
public class WechatUserService {

    @Autowired
    private WeChatUserMapper weChatUserMapper;

    @Autowired
    private WeChatUserExtraMapper weChatUserExtraMapper;


//    public WeChatUserExtra selectByUserId(Integer userId) {
//        WeChatUserExtra weChatUserExtra = weChatUserExtraMapper.selectByUserId(userId);
//
//    }


    public Integer getOrderCountByUserId(Integer userId) {
        Integer orderCount = weChatUserExtraMapper.selectOrderCountByUserId(userId);

        Preconditions.checkArgument(orderCount != null, "获取order count失败");

        return orderCount;
    }



    @Transactional
    public WeChatUser insertNotExist(String openId) {

        WeChatUser weChatUser = weChatUserMapper.selectByOpenId(openId);
        if(weChatUser != null) {
            return weChatUser;
        }

        //存储在wecharuser表
        weChatUser = new WeChatUser();
        weChatUser.setOpenId(openId);
        weChatUser.setIdentity(Const.WeChatIdentity.NORMAL.getCode());
        int row = weChatUserMapper.insert(weChatUser);
        Preconditions.checkArgument(row > 0, "存储openId失败");

        //存储weChatUserExtra表
        WeChatUserExtra weChatUserExtra = new WeChatUserExtra();
        weChatUserExtra.setUserId(weChatUser.getId());
        row = weChatUserExtraMapper.insert(weChatUserExtra);

        Preconditions.checkArgument(row > 0, "存储weChatUserExtra失败");
        return weChatUser;

    }

    public WeChatUser savePhone(String phone, String openId) {
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setPhone(phone);


        int row = weChatUserMapper.updateByOpenId(weChatUser);
        Preconditions.checkArgument(row>0, "存储用户手机号码失败");

        return weChatUser;
    }


    public WeChatUser saveInfo(String nickname, String gender, String openId) {
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setOpenId(openId);
        weChatUser.setGender(gender);
        weChatUser.setNickname(nickname);

        int row = weChatUserMapper.updateByOpenId(weChatUser);
        Preconditions.checkArgument(row>0, "存储用户信息失败");

        return weChatUser;
    }

    public WeChatUser selectByOpenId(String openId) {
        WeChatUser weChatUser = weChatUserMapper.selectByOpenId(openId);
        Preconditions.checkArgument(weChatUser!=null, "没有相关的用户");
        return weChatUser;
    }



}
