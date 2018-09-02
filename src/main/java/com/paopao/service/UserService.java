package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.util.BeanValidator;
import com.paopao.common.Const;
import com.paopao.dao.UserMapper;
import com.paopao.param.LoginParam;
import com.paopao.param.RegisterParam;
import com.paopao.po.User;
import com.paopao.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joker on 07/08/2018.
 */
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;



    public User login(LoginParam loginParam) {
        BeanValidator.check(loginParam);

        String encrytedPasswd = MD5Util.encrypt(loginParam.getPassword());
        User user = userMapper.findByUsernamePassword(loginParam.getUsername(), encrytedPasswd);
        Preconditions.checkArgument(user!=null, "不存在相关用户");
        user.setPassword("");

        return user;
    }

    public String register(RegisterParam registerParam) {
        BeanValidator.check(registerParam);
        int ans = userMapper.checkUsername(registerParam.getUsername());
        Preconditions.checkArgument(ans < 1, "已存在相关用户");

        User user = new User();
        user.setUsername(registerParam.getUsername());
        user.setPassword(MD5Util.encrypt(registerParam.getPassword()));
        user.setPhone(registerParam.getPhone());
        user.setEmail(registerParam.getEmail());
        user.setQuestion(registerParam.getQuestion());
        user.setAnswer(registerParam.getAnswer());
        user.setRole(Const.Role.NORMAL.getCode());

        ans = userMapper.insert(user);
        Preconditions.checkArgument(ans > 0, "注册失败");
        return "注册成功";
    }

}
