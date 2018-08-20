package com.paopao.po;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Long orderNo;

    private Integer userId;

    private Integer shippingId;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer status;

    private Date getTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo=" + orderNo +
                ", userId=" + userId +
                ", shippingId=" + shippingId +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", status=" + status +
                ", getTime=" + getTime +
                ", endTime=" + endTime +
                ", closeTime=" + closeTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Order(Integer id, Long orderNo, Integer userId, Integer shippingId, BigDecimal payment, Integer paymentType, Integer status, Date getTime, Date endTime, Date closeTime, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
        this.shippingId = shippingId;
        this.payment = payment;
        this.paymentType = paymentType;
        this.status = status;
        this.getTime = getTime;
        this.endTime = endTime;
        this.closeTime = closeTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
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