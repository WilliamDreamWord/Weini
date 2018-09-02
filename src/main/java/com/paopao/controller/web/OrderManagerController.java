package com.paopao.controller.web;

import com.paopao.common.JsonResponse;
import com.paopao.service.OrderService;
import com.paopao.vo.OrderManagerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping("list.do")
    public JsonResponse<List<OrderManagerVo>> orderList(@RequestParam(value = "pageNum", defaultValue = "1")
                                      int pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10")
                                      int pageSize) {

        return JsonResponse.createBySuccess(orderService.manageList(pageNum, pageSize));
    }

    @PostMapping("detail.do")
    public JsonResponse<OrderManagerVo> orderDetail(Long orderNo) {

        return JsonResponse.createBySuccess(orderService.manageDetail(orderNo));
    }



    @PostMapping("change_status.do")
    public JsonResponse<String> changeStatus(Integer orderId, Integer status) {
        orderService.manageChangeOrderStatus(orderId, status);
        return JsonResponse.createBySuccess("更改状态成功");

    }



    @PostMapping("count_status.do")
    public JsonResponse<Integer> countByStatus(Integer status) {
        int count = orderService.countByStatus(status);
        return JsonResponse.createBySuccess(count);
    }

    @PostMapping("count_all.do")
    public JsonResponse<Integer> countAll() {
        int count = orderService.manageCountAll();
        return JsonResponse.createBySuccess(count);
    }


    @PostMapping("select_date_status.do")
    public JsonResponse<List<OrderManagerVo>> selectDateStatus(String begin, String end, Integer status) {
        List<OrderManagerVo> orderVoList = orderService.selectByDateStatus(begin, end, status);
        return JsonResponse.createBySuccess(orderVoList);
    }

    @PostMapping("select_date_status_now.do")
    public JsonResponse<List<OrderManagerVo>> selectDateStatusNow(String begin, Integer status) {
        List<OrderManagerVo> orderVoList = orderService.selectByDateStatusNow(begin, status);
        return JsonResponse.createBySuccess(orderVoList);
    }
}
