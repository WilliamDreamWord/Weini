package com.paopao.controller.wechat;

import com.paopao.common.JsonResponse;
import com.paopao.param.CandidateParam;
import com.paopao.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joker on 04/09/2018.
 */
@RestController
@RequestMapping("/wechat/candidate/")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @PostMapping("add.do")
    public JsonResponse add(CandidateParam candidateParam) {

        candidateService.add(candidateParam);

        return JsonResponse.createBySuccess("添加成功");

    }
}
