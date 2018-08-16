package com.paopao.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.dao.WeChatUserMapper;
import com.paopao.exception.ParamException;
import com.paopao.po.WeChatUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joker on 12/08/2018.
 */
@Service
public class WechatUserService {

    @Autowired
    private WeChatUserMapper weChatUserMapper;

    @Autowired
    private WxMaService wxService;




    public WeChatUser login(String sessionKey, String openid, String unionId) {
        if (StringUtils.isEmpty(sessionKey) ||
                StringUtils.isEmpty(openid) ||
                StringUtils.isEmpty(unionId)) {
            throw  new ParamException("code有误, 无法解析");
        }
        WeChatUser weChatUser = weChatUserMapper.selectByOpenId(openid);
        if(weChatUser != null) {
            return weChatUser;
        }
        weChatUser = new WeChatUser();
        weChatUser.setOpenId(openid);
        weChatUser.setUnionId(unionId);
        weChatUser.setScore(0L);
        weChatUser.setIdentity(Const.WeChatIdentity.NORMAL.getCode());

        int row = weChatUserMapper.insert(weChatUser);
        Preconditions.checkArgument(row > 0, "添加微信用户失败");
        return weChatUser;

    }

    public void saveInfo(WeChatUser weChatUser) {
        int row = weChatUserMapper.updateByOpenId(weChatUser);
        Preconditions.checkArgument(row>0, "更新用户信息失败");

    }



}
