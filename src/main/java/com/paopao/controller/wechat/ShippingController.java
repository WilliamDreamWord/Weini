package com.paopao.controller.wechat;

import com.paopao.common.JsonResponse;
import com.paopao.param.ShippingParam;
import com.paopao.po.Shipping;
import com.paopao.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by joker on 13/08/2018.
 */


@RestController
@RequestMapping("/shipping/")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;


    @RequestMapping("add.do")
    public JsonResponse add(ShippingParam shippingParam) {

        Map<String, Integer> map = shippingService.add(shippingParam);

        return JsonResponse.createBySuccess(map);
    }


    @RequestMapping("del.do")
    public JsonResponse del(Integer userId, Integer shippingId) {
        shippingService.del(userId, shippingId);

        return JsonResponse.createBySuccess("删除成功");
    }


    @RequestMapping("update.do")
    public JsonResponse update(Shipping shipping) {
        shippingService.update(shipping);

        return JsonResponse.createBySuccess("更新成功");
    }


    @RequestMapping("select.do")
    public JsonResponse select(Integer userId, Integer shippingId) {
        Shipping shipping = shippingService.select(userId, shippingId);
        return JsonResponse.createBySuccess(shipping);
    }

    @RequestMapping("list.do")
    public JsonResponse list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                             Integer userId) {
        List<Shipping> shippings = shippingService.list(userId, pageNum, pageSize);

        return JsonResponse.createBySuccess(shippings);
    }

}
