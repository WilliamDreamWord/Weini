package com.paopao.po;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer authorId;

    private Integer entityType;

    private Integer entityId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Comment(Integer id, Integer authorId, Integer entityType, Integer entityId, Integer status, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.authorId = authorId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public Comment() {
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

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
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