package com.paopao.controller.wechat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.exception.ParamException;
import com.paopao.po.WeChatUser;
import com.paopao.service.WechatUserService;
import com.paopao.util.AesCbcUtil;
import com.paopao.util.HttpRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    private WechatUserService wechatUserService;

    @Value("${mini.appid}")
    private String wxspAppid;

    @Value("${mini.secret}")
    private String wxspSecret;

    @Value("${mini.grantType}")
    private String grantType;


    @PostMapping(value = "login.do")
    public JsonResponse<Map> login(String code, HttpSession httpSession) {

        if (StringUtils.isEmpty(code)) {
            throw  new ParamException("code为空");
        }




        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code="
                + code + "&grant_type=" + grantType;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）

        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = null;
        try {
            json = mapper.readTree(sr);
        } catch (IOException e) {
            throw new ParamException("无法解析微信参数");
        }

        String session_key = null;
        String openid = null;
        if (json.has("session_key") && json.get("session_key") != null) {
            //获取会话密钥（session_key）
             session_key = json.get("session_key").toString();
            //用户的唯一标识（openid）
             openid = json.get("openid").toString();

            String sessionId = httpSession.getId();
            httpSession.setAttribute(Const.CURRENT_WECHAT_USER_OPEN_ID, openid);
            httpSession.setAttribute(Const.CURRENT_WECHAT_USER_SESSION_KEY, session_key);

            Map<String, String> map = new HashMap<>();
            map.put("JSESSIONID", sessionId);

            return JsonResponse.createBySuccess(map);

        } else {
            logger.error("微信登录验证出错，json = {}", json);
            return JsonResponse.createByErrorMsg("微信返回参数出错了");
        }


    }

    @PostMapping("save_user_info.do")
    public JsonResponse saveUserInfo(String encryptedData, String iv, HttpSession httpSession) {

        String sessionKey = (String)httpSession.getAttribute(Const.CURRENT_WECHAT_USER_SESSION_KEY);
        String openId = (String)httpSession.getAttribute(Const.CURRENT_WECHAT_USER_OPEN_ID);
        try {
            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode userInfoJSON = mapper.readTree(result);
            wechatUserService.saveInfo(userInfoJSON.get("nickname").toString(),
                    userInfoJSON.get("gender").toString(), openId);

            return JsonResponse.createBySuccess("保存用户信息成功");

        } catch (Exception e) {
            logger.error("解密数据出错, session_key = {}", sessionKey);
            return JsonResponse.createByErrorMsg("解密错误");
        }

    }

    @PostMapping("get_user_info.do")
    public JsonResponse<WeChatUser> getUserInfo(HttpSession httpSession) {


        String openId = (String)httpSession.getAttribute(Const.CURRENT_WECHAT_USER_OPEN_ID);

        return JsonResponse.createBySuccess(wechatUserService.getUserInfo(openId));
    }









}
