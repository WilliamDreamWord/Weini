package com.paopao.controller.web;

import com.paopao.common.JsonResponse;
import com.paopao.service.OrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by joker on 06/09/2018.
 */

@RestController
@RequestMapping("/manager/order/")
public class OrderReturnApplyManagerController {


    @Autowired
    private OrderReturnApplyService orderReturnApplyService;


    @PostMapping("delete.do")
    public JsonResponse delete(Integer id, HttpSession httpSession) {
        orderReturnApplyService.delete(id);

        return JsonResponse.createBySuccess("删除申请成功");
    }

    @PostMapping("list_by_audit_status.do")
    public JsonResponse list(Integer auditStatus,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        orderReturnApplyService.list(auditStatus, pageNum, pageSize);

        return JsonResponse.createBySuccess("删除申请成功");
    }

    @PostMapping("pass.do")
    public JsonResponse pass(Integer id, String auditWhy, String comment) {
        orderReturnApplyService.pass(id, auditWhy, comment);
        return JsonResponse.createBySuccess("通过请求");
    }


    @PostMapping("refuse.do")
    public JsonResponse refuse(Integer id, String auditWhy, String comment) {
        orderReturnApplyService.refuse(id, auditWhy, comment);
        return JsonResponse.createBySuccess("拒绝请求");
    }






}
