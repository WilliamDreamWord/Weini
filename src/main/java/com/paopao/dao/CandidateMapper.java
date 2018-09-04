package com.paopao.dao;

import com.paopao.po.Candidate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CandidateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Candidate record);

    int insertSelective(Candidate record);

    Candidate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Candidate record);


    int updateByPrimaryKey(Candidate record);

    List<Candidate> list(@Param("begin") Integer begin, @Param("count") Integer count);
}