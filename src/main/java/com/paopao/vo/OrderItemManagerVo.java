package com.paopao.vo;

import java.math.BigDecimal;

/**
 * Created by joker on 03/09/2018.
 */
public class OrderItemManagerVo {

    private Long orderNo;

    private Integer packageId;

    private String packageName;

    private String exceptTime;

    private BigDecimal price;

    //提货码
    private String code;

    private String createTime;

    @Override
    public String toString() {
        return "OrderItemManagerVo{" +
                "orderNo=" + orderNo +
                ", packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", exceptTime='" + exceptTime + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public OrderItemManagerVo() {
    }

    public OrderItemManagerVo(Long orderNo, Integer packageId, String packageName, String exceptTime, BigDecimal price, String code, String createTime) {
        this.orderNo = orderNo;
        this.packageId = packageId;
        this.packageName = packageName;
        this.exceptTime = exceptTime;
        this.price = price;
        this.code = code;
        this.createTime = createTime;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getExceptTime() {
        return exceptTime;
    }

    public void setExceptTime(String exceptTime) {
        this.exceptTime = exceptTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
