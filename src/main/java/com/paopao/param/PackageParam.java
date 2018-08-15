package com.paopao.param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by joker on 13/08/2018.
 */
public class PackageParam {


    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @NotNull(message = "包裹名不能为空")
    @Length(min=1, max = 50, message = "请给包裹取个名字吧")
    private String name;


    @NotNull(message = "地址不能为空")
    @Length(min=1, max = 50, message = "没有填写收货地址")
    private String address;


    @NotNull(message = "取货码不能为空")
    @Length(min=1, max = 50, message = "没有填写提货码")
    private String code;

    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @NotNull(message = "包裹类型不能为空")
    private Integer packageType;


    private String detail;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPackageType() {
        return packageType;
    }

    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
