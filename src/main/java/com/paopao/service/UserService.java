package com.paopao.service;

import com.paopao.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joker on 07/08/2018.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;



}
