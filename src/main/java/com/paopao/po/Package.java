package com.paopao.po;

import java.math.BigDecimal;
import java.util.Date;

public class Package {
    private Integer id;

    private Integer userId;

    private String name;

    private String address;

    private BigDecimal price;

    private String code;

    private Integer packageType;

    private Integer status;

    private String exceptTime;

    private Date createTime;

    private Date updateTime;

    private String detail;

    public Package(Integer id, Integer userId, String name, String address, BigDecimal price, String code, Integer packageType, Integer status, String exceptTime, Date createTime, Date updateTime, String detail) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.price = price;
        this.code = code;
        this.packageType = packageType;
        this.status = status;
        this.exceptTime = exceptTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.detail = detail;
    }

    public Package() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
        this.code = code == null ? null : code.trim();
    }

    public Integer getPackageType() {
        return packageType;
    }

    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExceptTime() {
        return exceptTime;
    }

    public void setExceptTime(String exceptTime) {
        this.exceptTime = exceptTime == null ? null : exceptTime.trim();
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}