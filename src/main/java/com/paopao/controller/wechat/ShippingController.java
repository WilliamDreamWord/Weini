package com.paopao.controller.wechat;

import com.paopao.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joker on 13/08/2018.
 */


@RestController
@RequestMapping("/wechat/shipping/")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

//
//    @PostMapping("add.do")
//    public JsonResponse<Shipping> add(ShippingParam shippingParam, HttpSession httpSession) {
//        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
//        shippingParam.setUserId(weChatUser.getId());
//        Shipping shipping = shippingService.add(shippingParam);
//
//        return JsonResponse.createBySuccess(shipping);
//    }
//
//
//    @PostMapping("delete.do")
//    public JsonResponse delete(HttpSession httpSession, Integer shippingId) {
//        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
//        shippingService.del(weChatUser.getId(), shippingId);
//
//        return JsonResponse.createBySuccess("删除成功");
//    }
//
//
//    @PostMapping("update.do")
//    public JsonResponse update(Integer shippingId, ShippingParam shippingParam, HttpSession httpSession) {
//        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
//        shippingParam.setUserId(weChatUser.getId());
//        shippingService.update(shippingId, shippingParam);
//
//        return JsonResponse.createBySuccess("更新成功");
//    }
//
//
//    @PostMapping("select.do")
//    public JsonResponse select(HttpSession httpSession, Integer shippingId) {
//        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
//        Shipping shipping = shippingService.select(weChatUser.getId(), shippingId);
//        return JsonResponse.createBySuccess(shipping);
//    }
//
//
//
//    @PostMapping("list.do")
//    public JsonResponse list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
//                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
//                             HttpSession httpSession) {
//
//        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
//        List<Shipping> shippings = shippingService.list(weChatUser.getId(), pageNum, pageSize);
//
//        return JsonResponse.createBySuccess(shippings);
//    }

}
