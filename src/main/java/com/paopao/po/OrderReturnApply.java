package com.paopao.po;

import java.util.Date;

public class OrderReturnApply {
    private Integer id;

    private Integer userId;

    private Long orderNo;

    private Integer type;

    private Integer orderStatus;

    private String why;

    private Integer auditStatus;

    private Date auditTime;

    private String auditWhy;

    private Date createTime;

    private Date updateTime;

    private String comment;

    public OrderReturnApply(Integer id, Integer userId, Long orderNo, Integer type, Integer orderStatus, String why, Integer auditStatus, Date auditTime, String auditWhy, Date createTime, Date updateTime, String comment) {
        this.id = id;
        this.userId = userId;
        this.orderNo = orderNo;
        this.type = type;
        this.orderStatus = orderStatus;
        this.why = why;
        this.auditStatus = auditStatus;
        this.auditTime = auditTime;
        this.auditWhy = auditWhy;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.comment = comment;
    }

    public OrderReturnApply() {
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

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why == null ? null : why.trim();
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditWhy() {
        return auditWhy;
    }

    public void setAuditWhy(String auditWhy) {
        this.auditWhy = auditWhy == null ? null : auditWhy.trim();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    @Override
    public String toString() {
        return "OrderReturnApply{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNo=" + orderNo +
                ", type=" + type +
                ", orderStatus=" + orderStatus +
                ", why='" + why + '\'' +
                ", auditStatus=" + auditStatus +
                ", auditTime=" + auditTime +
                ", auditWhy='" + auditWhy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}