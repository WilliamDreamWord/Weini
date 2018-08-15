package com.paopao.controller.webchat;

import com.paopao.common.JsonResponse;
import com.paopao.service.OrderService;
import com.paopao.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by joker on 13/08/2018.
 */

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("add.do")
    public JsonResponse<OrderVo> add(Integer userId, Integer shippingId, Integer packageId) {

        OrderVo orderVo =  orderService.addOrder(packageId, shippingId, userId);

        return JsonResponse.createBySuccess(orderVo);
    }

    @RequestMapping("cancel.do")
    public JsonResponse cancel(Integer userId, Long orderNo) {
        orderService.cancel(userId, orderNo);

        return JsonResponse.createBySuccess("取消成功");
    }

    @RequestMapping("get_order.do")
    public JsonResponse<OrderVo> getOrder(Integer userId, Long orderNo) {
        OrderVo orderVo = orderService.getOrder(userId, orderNo);

        return JsonResponse.createBySuccess(orderVo);
    }


    @RequestMapping("list.do")
    public JsonResponse<List<OrderVo>> getOrderList(Integer userId,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<OrderVo> orderVoList = orderService.getOrderList(userId, pageNum, pageSize);

        return JsonResponse.createBySuccess(orderVoList);
    }





}
