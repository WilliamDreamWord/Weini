package com.paopao.param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by joker on 09/08/2018.
 */


public class LoginParam {


    @NotNull
    @Length(min = 1, max = 20, message = "用户名必须在1-20位之间")
    private String username;

    @NotNull
    @Length(min = 1, max = 20, message = "密码必须在1-20位之间")
    private String password;

    @Override
    public String toString() {
        return "LoginParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
