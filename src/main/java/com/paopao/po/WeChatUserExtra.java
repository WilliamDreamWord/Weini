package com.paopao.po;

import java.util.Date;

public class WeChatUserExtra {
    private Integer id;

    private Integer userId;

    private Integer orderCount;

    private Long credit;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public WeChatUserExtra(Integer id, Integer userId, Integer orderCount, Long credit, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.orderCount = orderCount;
        this.credit = credit;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public WeChatUserExtra() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
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
}