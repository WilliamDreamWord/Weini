package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.convert.CandidateConvert;
import com.paopao.dao.CandidateMapper;
import com.paopao.param.CandidateParam;
import com.paopao.po.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void del(Integer id) {
        int row = candidateMapper.deleteByPrimaryKey(id);
        Preconditions.checkArgument(row > 0, "删除失败");
    }

    public Candidate findById(Integer id) {
        Candidate candidate = candidateMapper.selectByPrimaryKey(id);

        Preconditions.checkArgument(candidate!=null, "没有相关记录");
        return candidate;
    }

    public List<Candidate> list(Integer pageNum, Integer pageSize) {
        return candidateMapper.list((pageNum-1)*pageSize, pageSize);
    }

}
