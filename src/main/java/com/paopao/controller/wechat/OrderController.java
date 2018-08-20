package com.paopao.controller.wechat;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.po.WeChatUser;
import com.paopao.service.OrderService;
import com.paopao.vo.OrderVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/wechat/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ApiOperation(value="创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shippingId"),
            @ApiImplicitParam(name = "packageId")
    })
    @PostMapping("add.do")
    public JsonResponse<OrderVo> add(Integer shippingId, Integer packageId, HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        OrderVo orderVo =  orderService.addOrder(packageId, shippingId, weChatUser.getId());

        return JsonResponse.createBySuccess(orderVo);
    }


    @ApiOperation(value="取消订单")
    @ApiImplicitParam(name = "orderNo")
    @PostMapping("cancel.do")
    public JsonResponse cancel(Long orderNo, HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        orderService.cancel(weChatUser.getId(), orderNo);

        return JsonResponse.createBySuccess("取消成功");
    }


    @ApiOperation(value="得到订单")
    @ApiImplicitParam(name = "orderNo")
    @PostMapping("get_order.do")
    public JsonResponse<OrderVo> getOrder(Long orderNo, HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        OrderVo orderVo = orderService.getOrder(weChatUser.getId(), orderNo);

        return JsonResponse.createBySuccess(orderVo);
    }


    @ApiOperation(value="得到订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum"),
            @ApiImplicitParam(name = "pageSize")
    })
    @PostMapping("list.do")
    public JsonResponse<List<OrderVo>> getOrderList(HttpSession httpSession,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        List<OrderVo> orderVoList = orderService.getOrderList(weChatUser.getId(), pageNum, pageSize);

        return JsonResponse.createBySuccess(orderVoList);
    }


    @PostMapping("count_all.do")
    public JsonResponse<Integer> countAll(HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        int count = orderService.countByUserId(weChatUser.getId());
        return JsonResponse.createBySuccess(count);
    }






}
