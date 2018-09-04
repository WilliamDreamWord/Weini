package com.paopao.controller.web;

import com.paopao.common.JsonResponse;
import com.paopao.po.Feedback;
import com.paopao.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by joker on 01/09/2018.
 */
@RestController
@RequestMapping("/manager/feedback/")
public class FeedbackManagerController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("list.do")
    public JsonResponse<List<Feedback>> list(@RequestParam(value = "pageNum", defaultValue = "1")
                                                 int pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10")
                                                 int pageSize) {
        return JsonResponse.createBySuccess(feedbackService.list(pageNum, pageSize));
    }

    @PostMapping("del.do")
    public JsonResponse del(Integer id) {
        feedbackService.del(id);
        return JsonResponse.createBySuccess("删除反馈成功");
    }

    @PostMapping("find_by_id.do")
    public JsonResponse findById(Integer id) {
        Feedback feedback = feedbackService.findById(id);
        return JsonResponse.createBySuccess(feedback);
    }



}
