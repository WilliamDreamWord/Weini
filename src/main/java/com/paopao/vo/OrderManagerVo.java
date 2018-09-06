package com.paopao.vo;

import com.paopao.po.OrderShipping;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by joker on 03/09/2018.
 */
public class OrderManagerVo {


    private Long orderNo;
    private BigDecimal payment;
    private Integer paymentType;
    private String paymentTypeDesc;
    private Integer status;
    private String statusDesc;


    private String getTime;

    private String endTime;

    private String closeTime;

    private String createTime;


    //订单明细
    private List<OrderItemManagerVo> orderItemVoList;

    //该用户下单数
    private Integer orderCount;

    private Integer shippingId;
    private String receiverName;

    private OrderShipping shipping;

    @Override
    public String toString() {
        return "OrderManagerVo{" +
                "orderNo=" + orderNo +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", paymentTypeDesc='" + paymentTypeDesc + '\'' +
                ", status=" + status +
                ", statusDesc='" + statusDesc + '\'' +
                ", getTime='" + getTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", orderItemVoList=" + orderItemVoList +
                ", orderCount=" + orderCount +
                ", shippingId=" + shippingId +
                ", receiverName='" + receiverName + '\'' +
                ", shipping=" + shipping +
                '}';
    }


    public OrderManagerVo() {
    }

    public OrderManagerVo(Long orderNo, BigDecimal payment, Integer paymentType, String paymentTypeDesc, Integer status, String statusDesc, String getTime, String endTime, String closeTime, String createTime, List<OrderItemManagerVo> orderItemVoList, Integer orderCount, Integer shippingId, String receiverName, OrderShipping shipping) {
        this.orderNo = orderNo;
        this.payment = payment;
        this.paymentType = paymentType;
        this.paymentTypeDesc = paymentTypeDesc;
        this.status = status;
        this.statusDesc = statusDesc;
        this.getTime = getTime;
        this.endTime = endTime;
        this.closeTime = closeTime;
        this.createTime = createTime;
        this.orderItemVoList = orderItemVoList;
        this.orderCount = orderCount;
        this.shippingId = shippingId;
        this.receiverName = receiverName;
        this.shipping = shipping;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
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

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }


    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<OrderItemManagerVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemManagerVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public OrderShipping getShipping() {
        return shipping;
    }

    public void setShipping(OrderShipping shipping) {
        this.shipping = shipping;
    }
}
