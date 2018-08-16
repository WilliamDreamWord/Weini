package com.paopao.controller.wechat;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import com.paopao.po.WeChatUser;
import com.paopao.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by joker on 13/08/2018.
 */


@RestController
@RequestMapping("/wechat/shipping/")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;


    @RequestMapping("add.do")
    public JsonResponse add(ShippingParam shippingParam) {

        Map<String, Integer> map = shippingService.add(shippingParam);

        return JsonResponse.createBySuccess(map);
    }


    @RequestMapping("del.do")
    public JsonResponse del(HttpSession httpSession, Integer shippingId) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        shippingService.del(weChatUser.getId(), shippingId);

        return JsonResponse.createBySuccess("删除成功");
    }


    @RequestMapping("update.do")
    public JsonResponse update(Integer shippingId, ShippingParam shippingParam, HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        shippingParam.setUserId(weChatUser.getId());
        shippingService.update(shippingId, shippingParam);

        return JsonResponse.createBySuccess("更新成功");
    }


    @RequestMapping("select.do")
    public JsonResponse select(HttpSession httpSession, Integer shippingId) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        Shipping shipping = shippingService.select(weChatUser.getId(), shippingId);
        return JsonResponse.createBySuccess(shipping);
    }

    @RequestMapping("list.do")
    public JsonResponse list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                             HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        List<Shipping> shippings = shippingService.list(weChatUser.getId(), pageNum, pageSize);

        return JsonResponse.createBySuccess(shippings);
    }

}
