package com.paopao.po;

import java.math.BigDecimal;
import java.util.Date;

public class Package {
    private Integer id;

    private String name;

    private BigDecimal price;

    private String code;

    private Integer packageType;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String detail;

    public Package(Integer id, String name, BigDecimal price, String code, Integer packageType, Integer status, Date createTime, Date updateTime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.code = code;
        this.packageType = packageType;
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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