package com.paopao.param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Created by joker on 11/08/2018.
 */
public class RegisterParam {

    // TODO: 15/08/2018 notnull message
    @NotEmpty
    @Length(min = 1, max = 20, message = "用户名必须在1-20位之间")
    private String username;

    @NotEmpty
    @Length(min = 1, max = 20, message = "密码必须在1-20位之间")
    private String password;


    @Email
    private String email;

    //check phone number
    @Pattern(regexp="(^$|[0-9]{13})")
    private String phone;

    @NotEmpty
    @Length(min = 1, max = 100, message = "找回密码问题必须在1-100之间")
    private String question;

    @NotEmpty
    @Length(min = 1, max = 100, message = "找回密码答案必须在1-100之间")
    private String answer;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
