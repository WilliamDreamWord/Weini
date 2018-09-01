package com.paopao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by joker on 01/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest {

    @Autowired
    private FeedbackService feedbackService;


    @Test
    public void shouldAdd() {
        feedbackService.add(11, "麦兜家粉丝都 i 即佛");
    }

    @Test
    public void shouldSelect() {
        System.out.println(feedbackService.findById(119));
    }

    @Test
    public void list() {
        System.out.println(feedbackService.list());
    }
}
