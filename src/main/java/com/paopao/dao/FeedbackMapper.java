package com.paopao.dao;

import com.paopao.po.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);


    int updateByPrimaryKey(Feedback record);

    List<Feedback> list(@Param("begin") Integer begin, @Param("count") Integer count);
}