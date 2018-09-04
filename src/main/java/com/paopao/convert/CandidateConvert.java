package com.paopao.convert;

import com.paopao.param.CandidateParam;
import com.paopao.po.Candidate;
import com.paopao.util.BeanValidator;

/**
 * Created by joker on 04/09/2018.
 */
public class CandidateConvert {

    public static Candidate of(CandidateParam candidateParam) {

        BeanValidator.check(candidateParam);

        Candidate candidate = new Candidate();
        candidate.setName(candidateParam.getName());
        candidate.setAddress(candidateParam.getAddress());
        candidate.setGender(candidateParam.getGender());
        candidate.setPhone(candidateParam.getPhone());
        candidate.setQq(candidateParam.getPhone());
        candidate.setComment(candidateParam.getComment());

        return candidate;
    }
}
