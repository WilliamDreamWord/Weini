package com.paopao.controller.web;

import com.paopao.common.JsonResponse;
import com.paopao.service.OrderService;
import com.paopao.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by joker on 15/08/2018.
 */
@RestController
@RequestMapping("/manager/order/")
public class OrderManagerController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("list.do")
    public JsonResponse<List<OrderVo>> orderList(@RequestParam(value = "pageNum", defaultValue = "1")
                                      int pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")
                                      int pageSize) {

        return JsonResponse.createBySuccess(orderService.manageList(pageNum, pageSize));
    }

    @RequestMapping("detail.do")
    public JsonResponse<OrderVo> orderDetail(Long orderNo) {

        return JsonResponse.createBySuccess(orderService.manageDetail(orderNo));
    }

    @RequestMapping("search.do")
    public JsonResponse<List<OrderVo>> orderSearch(Integer userId,
                                                @RequestParam(value = "pageNum", defaultValue = "1")
                                                int pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10")
                                                int pageSize) {


        return JsonResponse.createBySuccess(orderService.manageSearchByUserId(userId, pageNum, pageSize));

    }

    @RequestMapping("send_goods.do")
    public JsonResponse<String> orderSendGoods(Long orderNo) {
        orderService.manageSendGoods(orderNo);
        return JsonResponse.createBySuccess("接单成功");

    }


}
