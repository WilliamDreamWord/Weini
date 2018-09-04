package com.paopao.controller.wechat;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.po.WeChatUser;
import com.paopao.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by joker on 01/09/2018.
 */
@RestController
@RequestMapping("/wechat/feedback/")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("add.do")
    public JsonResponse add(String content, HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        feedbackService.add(weChatUser.getId(), content);

        return JsonResponse.createBySuccess("添加反馈成功");
    }




}
