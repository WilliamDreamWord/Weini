package com.paopao.controller;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.param.LoginParam;
import com.paopao.param.RegisterParam;
import com.paopao.po.User;
import com.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login.do")
    public JsonResponse<User> login(LoginParam loginParam, HttpSession httpSession) {

        User user = userService.login(loginParam);

        httpSession.setAttribute(Const.CURRENT_USER, user);

        return JsonResponse.createBySuccess(user);
    }

    @PostMapping("register.do")
    public JsonResponse<String> register(RegisterParam registerParam) {


        return JsonResponse.createBySuccess(userService.register(registerParam));
    }

}
