package com.paopao.controller.wechat;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.po.WeChatUser;
import com.paopao.service.OrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by joker on 06/09/2018.
 */
@RestController
@RequestMapping("/wechat/order_return_apply/")
public class OrderReturnApplyController {

    @Autowired
    private OrderReturnApplyService orderReturnApplyService;


    @PostMapping("apply_cancel.do")
    public JsonResponse applyCancel(Long orderNo, String way, HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        orderReturnApplyService.add(weChatUser.getId(), orderNo, way);

        return JsonResponse.createBySuccess("申请成功");
    }





}
