package com.paopao.controller.web;

import com.paopao.common.JsonResponse;
import com.paopao.service.OrderService;
import com.paopao.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by joker on 15/08/2018.
 */
@RestController
@RequestMapping("/manager/order/")
public class OrderManagerController {

    @Autowired
    private OrderService orderService;


    @PostMapping("list.do")
    public JsonResponse<List<OrderVo>> orderList(@RequestParam(value = "pageNum", defaultValue = "1")
                                      int pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")
                                      int pageSize) {

        return JsonResponse.createBySuccess(orderService.manageList(pageNum, pageSize));
    }

    @PostMapping("detail.do")
    public JsonResponse<OrderVo> orderDetail(Long orderNo) {

        return JsonResponse.createBySuccess(orderService.manageDetail(orderNo));
    }

    @PostMapping("search.do")
    public JsonResponse<List<OrderVo>> orderSearch(Integer userId,
                                                @RequestParam(value = "pageNum", defaultValue = "1")
                                                int pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10")
                                                int pageSize) {


        return JsonResponse.createBySuccess(orderService.manageSearchByUserId(userId, pageNum, pageSize));

    }

    @PostMapping("accept_order.do")
    public JsonResponse<String> acceptOrder(Long orderNo) {
        orderService.manageAcceptOrder(orderNo);
        return JsonResponse.createBySuccess("接单成功");

    }

    @PostMapping("finish_order.do")
    public JsonResponse<String> finishOrder(Long orderNo) {
        orderService.manageFinishOrder(orderNo);
        return JsonResponse.createBySuccess("完成订单成功");

    }


    @PostMapping("count_by_user_id.do")
    public JsonResponse<Integer> countByUserId(Integer userId) {
        int count = orderService.countByUserId(userId);
        return JsonResponse.createBySuccess(count);
    }

    @PostMapping("count_by_user_id_status.do")
    public JsonResponse<Integer> countByUserId(Integer userId, Integer status) {
        int count = orderService.countByStatus(userId, status);
        return JsonResponse.createBySuccess(count);
    }

    @PostMapping("count_all.do")
    public JsonResponse<Integer> countAll() {
        int count = orderService.manageCountAll();
        return JsonResponse.createBySuccess(count);
    }


    @PostMapping("count_complex.do")
    public JsonResponse<List<OrderVo>> countByStatus(Integer userId, Date begin, Date end, Integer status) {
        List<OrderVo> orderVoList = orderService.selectByUserIdDateStatus(userId, begin, end, status);
        return JsonResponse.createBySuccess(orderVoList);
    }
}
