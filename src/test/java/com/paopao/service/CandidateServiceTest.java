package com.paopao.service;

import com.paopao.common.Const;
import com.paopao.param.CandidateParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by joker on 04/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateServiceTest {

    @Autowired
    private CandidateService candidateService;

    @Test
    public void shouldAdd() {
        CandidateParam candidateParam = new CandidateParam();
        candidateParam.setPhone("12394151341");
        candidateParam.setQq("4134143");
        candidateParam.setGender(Const.Gender.MALE.getCode());
        candidateParam.setAddress("哦肌肤都发觉");
        candidateParam.setName("扣扣玩");
        candidateParam.setComment("i 哦独家发售皮肤科啪啪啪尺码拍1");

        candidateService.add(candidateParam);
    }


}
