package com.paopao.param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by joker on 13/08/2018.
 */
public class PackageParam {

    private Integer id;

    @NotNull
    @Length(min=1, max = 50, message = "请给包裹取个名字吧")
    private String name;


    @NotNull
    @Length(min=1, max = 50, message = "没有填写收货地址")
    private String address;


    @NotNull
    @Length(min=1, max = 50, message = "没有填写提货码")
    private String code;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer packageType;


    private String detail;
}
