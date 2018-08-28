package com.paopao.po;

import java.util.Date;

public class Feedback {
    private Integer id;

    private Integer authorId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Feedback(Integer id, Integer authorId, Integer status, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.authorId = authorId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public Feedback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}