package com.paopao.controller.web;

import com.paopao.common.JsonResponse;
import com.paopao.po.Candidate;
import com.paopao.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by joker on 05/09/2018.
 */
@RestController
@RequestMapping("/manager/candidate/")
public class CandidateManagerController {


    @Autowired
    private CandidateService candidateService;


    @PostMapping("del.do")
    public JsonResponse del(Integer id) {
        candidateService.del(id);
        return JsonResponse.createBySuccess("删除成功");
    }

    @PostMapping("list.do")
    public JsonResponse<List<Candidate>> list(@RequestParam(value = "pageNum", defaultValue = "1")
                                                  int pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "10")
                                                  int pageSize) {

        return JsonResponse.createBySuccess(candidateService.list(pageNum, pageSize));
    }

    @PostMapping("find_by_id.do")
    public JsonResponse findById(Integer id) {
        return JsonResponse.createBySuccess(candidateService.findById(id));
    }

}
