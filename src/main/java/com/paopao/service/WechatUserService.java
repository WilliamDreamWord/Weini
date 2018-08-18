package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.dao.WeChatUserMapper;
import com.paopao.po.WeChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * Created by joker on 12/08/2018.
 */
@Service
@PropertySource("classpath:wechat.properties")
public class WechatUserService {

    @Autowired
    private WeChatUserMapper weChatUserMapper;



    public void savePhone(String phone, String openId) {
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setPhone(phone);


        int row = weChatUserMapper.updateByOpenId(weChatUser);
        Preconditions.checkArgument(row>0, "存储用户手机号码失败");
    }


    public void saveInfo(String nickname, String gender, String openId) {
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setOpenId(openId);
        weChatUser.setGender(gender);
        weChatUser.setNickname(nickname);

        int row = weChatUserMapper.updateByOpenId(weChatUser);
        Preconditions.checkArgument(row>0, "存储用户信息失败");

    }

    public WeChatUser getUserInfo(String openId) {
        WeChatUser weChatUser = weChatUserMapper.selectByOpenId(openId);
        Preconditions.checkNotNull(weChatUser, "没有相关的用户");
        return weChatUser;
    }



}
