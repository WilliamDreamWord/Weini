package com.paopao.controller.wechat;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.exception.ParamException;
import com.paopao.po.WeChatUser;
import com.paopao.service.WechatUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joker on 12/08/2018.
 */

@RestController
@RequestMapping("/wechat/user/")
public class WechatUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMaService wxService;

    @Autowired
    private WechatUserService wechatUserService;



    /**
     * 登陆接口
     */
    @PostMapping("login.do")
    public JsonResponse login(String code, HttpSession httpSession) {
        if (StringUtils.isEmpty(code)) {
            throw new ParamException("code为空");
        }

        try {
            WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());

            String sessionId = httpSession.getId();
            httpSession.setAttribute(Const.CURRENT_WECHAT_USER_SESSION_KEY, session.getSessionKey());
            httpSession.setAttribute(Const.CURRENT_WECHAT_USER_OPEN_ID, session.getOpenid());

            WeChatUser weChatUser = wechatUserService.login(
                    session.getSessionKey(), session.getOpenid(), session.getUnionid());
            logger.info("wechat user = {}", weChatUser);
            httpSession.setAttribute(Const.CURRENT_WECHAT_USER, weChatUser);


            Map<String, String> map = new HashMap<>();
            map.put("JSESSIONID", sessionId);

            return JsonResponse.createBySuccess(map);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            throw new ParamException(e.getMessage());
        }
    }

    /**
     * 获取用户信息接口
     */
    @GetMapping("info.do")
    public JsonResponse info(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            throw new ParamException("传入参数有误");
        }

        // 解密用户信息
        WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setOpenId(userInfo.getOpenId());
        weChatUser.setNickname(userInfo.getNickName());
        weChatUser.setGender(userInfo.getGender());
        wechatUserService.saveInfo(weChatUser);

        return JsonResponse.createBySuccess("更新用户信息成功");
    }

    /**
     * 获取用户绑定手机号信息
     */
    @GetMapping("phone.do")
    public JsonResponse phone(String sessionKey, String signature,
                              String rawData, String encryptedData,
                              String iv, HttpSession httpSession) {
        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            throw  new ParamException("传入参数有误");
        }


        String openId = (String)httpSession.getAttribute(Const.CURRENT_WECHAT_USER_OPEN_ID);
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = this.wxService.getUserService().getPhoneNoInfo(sessionKey,
                encryptedData, iv);
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setOpenId(openId);
        weChatUser.setPhone(phoneNoInfo.getPhoneNumber());
        wechatUserService.saveInfo(weChatUser);


        return JsonResponse.createBySuccess("更新用户信息成功");
    }





}
