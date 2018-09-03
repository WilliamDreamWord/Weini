package com.paopao.vo;

import com.paopao.po.Package;

import java.math.BigDecimal;

/**
 * Created by joker on 03/09/2018.
 */
public class OrderItemManagerVo {

    private Long orderNo;


    private BigDecimal totalPrice;

    private Package pack;

    private String createTime;

    @Override
    public String toString() {
        return "OrderItemManagerVo{" +
                "orderNo=" + orderNo +
                ", totalPrice=" + totalPrice +
                ", pack=" + pack +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public OrderItemManagerVo() {
    }

    public OrderItemManagerVo(Long orderNo, BigDecimal totalPrice, Package pack, String createTime) {
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.pack = pack;
        this.createTime = createTime;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
