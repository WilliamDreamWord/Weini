package com.paopao.param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by joker on 04/09/2018.
 */
public class CandidateParam {


    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotNull(message = "性别不能为空")
    private Integer gender;

    @NotEmpty(message = "qq不能为空")
    private String qq;

    @NotEmpty(message = "电话不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    private String comment;

    @Override
    public String toString() {
        return "CandidateParam{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public CandidateParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
