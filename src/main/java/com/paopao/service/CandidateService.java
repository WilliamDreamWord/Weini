package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.convert.CandidateConvert;
import com.paopao.dao.CandidateMapper;
import com.paopao.param.CandidateParam;
import com.paopao.po.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joker on 04/09/2018.
 */
@Service
public class CandidateService {

    @Autowired
    private CandidateMapper candidateMapper;


    public void add(CandidateParam candidateParam) {
        Candidate candidate = CandidateConvert.of(candidateParam);

        int row = candidateMapper.insert(candidate);

        Preconditions.checkArgument(row > 0, "添加候选人信息失败");
    }

}
