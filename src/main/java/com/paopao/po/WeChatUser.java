package com.paopao.po;

import java.util.Date;

public class WeChatUser {
    private Integer id;

    private String openId;

    private String unionId;

    private String nickname;

    private String gender;

    private String phone;

    private Long score;

    private Integer identity;

    private Date createTime;

    private Date updateTime;

    public WeChatUser(Integer id, String openId, String unionId, String nickname, String gender, String phone, Long score, Integer identity, Date createTime, Date updateTime) {
        this.id = id;
        this.openId = openId;
        this.unionId = unionId;
        this.nickname = nickname;
        this.gender = gender;
        this.phone = phone;
        this.score = score;
        this.identity = identity;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public WeChatUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}