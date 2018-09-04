package com.paopao.dao;

import com.paopao.po.Candidate;

public interface CandidateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Candidate record);

    int insertSelective(Candidate record);

    Candidate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Candidate record);


    int updateByPrimaryKey(Candidate record);
}