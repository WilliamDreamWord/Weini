package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.dao.FeedbackMapper;
import com.paopao.po.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by joker on 01/09/2018.
 */
@Service
public class FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;


    public void add(Integer userId, String content) {

        Feedback feedback = new Feedback();
        feedback.setAuthorId(userId);
        feedback.setStatus(Const.FeedbackStatusEnum.SHOW.getCode());
        feedback.setContent(content);

        int row = feedbackMapper.insert(feedback);

        Preconditions.checkArgument(row>0, "添加反馈失败");
    }

    public List<Feedback> list(Integer pageNum, Integer pageSize) {

        return feedbackMapper.list((pageNum-1)*pageSize, pageSize);
    }


    public Feedback findById(Integer id) {
        Feedback feedback = feedbackMapper.selectByPrimaryKey(id);
        Preconditions.checkArgument(feedback!=null, "没有找到相关回馈");
        return feedback;
    }


    public void del(Integer id) {
        int row = feedbackMapper.deleteByPrimaryKey(id);
        Preconditions.checkArgument(row>0, "删除反馈失败");

    }
}
