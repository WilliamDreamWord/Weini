package com.paopao.controller.wechat;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import com.paopao.po.WeChatUser;
import com.paopao.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by joker on 13/08/2018.
 */


@RestController
@RequestMapping("/wechat/shipping/")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;


    @PostMapping("add.do")
    public JsonResponse<Shipping> add(ShippingParam shippingParam, HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        shippingParam.setUserId(weChatUser.getId());
        Shipping shipping = shippingService.add(shippingParam);

        return JsonResponse.createBySuccess(shipping);
    }


    @PostMapping("delete.do")
    public JsonResponse delete(HttpSession httpSession, Integer shippingId) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        shippingService.del(weChatUser.getId(), shippingId);

        return JsonResponse.createBySuccess("删除成功");
    }


    @PostMapping("update.do")
    public JsonResponse update(Shipping shipping, HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        shipping.setUserId(weChatUser.getId());
        shippingService.update(shipping);

        return JsonResponse.createBySuccess("更新成功");
    }


    @PostMapping("select.do")
    public JsonResponse<Shipping> select(HttpSession httpSession, Integer shippingId) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        Shipping shipping = shippingService.select(weChatUser.getId(), shippingId);
        return JsonResponse.createBySuccess(shipping);
    }



    @PostMapping("list.do")
    public JsonResponse<List<Shipping>> list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                             HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        List<Shipping> shippings = shippingService.list(weChatUser.getId(), pageNum, pageSize);

        return JsonResponse.createBySuccess(shippings);
    }

    @PostMapping("select_default.do")
    public JsonResponse<Shipping> selectDefault(HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        Shipping shipping = shippingService.selectDefault(weChatUser.getId());
        return JsonResponse.createBySuccess(shipping);
    }

    @PostMapping("change_to_default.do")
    public JsonResponse changeToDefault(Integer userId, Integer shippingId) {
        boolean ans = shippingService.changeToDefault(userId, shippingId);
        if (ans) {
            return JsonResponse.createBySuccess("成功修改");
        } else {
            return JsonResponse.createByErrorMsg("修改失败");
        }
    }


    @PostMapping("change_to_normal.do")
    public JsonResponse changeToNormal(Integer userId, Integer shippingId) {
        boolean ans = shippingService.changeToNormal(userId, shippingId);
        if (ans) {
            return JsonResponse.createBySuccess("成功修改");
        } else {
            return JsonResponse.createByErrorMsg("修改失败");
        }
    }


}
