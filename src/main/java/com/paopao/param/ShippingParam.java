package com.paopao.param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by joker on 14/08/2018.
 */
public class ShippingParam {


    @NotNull(message = "用户id不能空")
    private Integer userId;

    @NotEmpty(message = "收货名称不能空")
    private String receiverName;

    @NotEmpty(message = "收货手机不能空")
    private String receiverMobile;

    @NotEmpty(message = "大区域地址不能空")
    private String receiverLargeArea;

    @NotEmpty(message = "中区域地址不能空")
    private String receiverMediumArea;

    @NotEmpty(message = "小区域地址不能空")
    private String receiverSmallArea;

    @NotEmpty(message = "门牌号不能空")
    private String receiverDoor;

    private Integer status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverLargeArea() {
        return receiverLargeArea;
    }

    public void setReceiverLargeArea(String receiverLargeArea) {
        this.receiverLargeArea = receiverLargeArea;
    }

    public String getReceiverMediumArea() {
        return receiverMediumArea;
    }

    public void setReceiverMediumArea(String receiverMediumArea) {
        this.receiverMediumArea = receiverMediumArea;
    }

    public String getReceiverSmallArea() {
        return receiverSmallArea;
    }

    public void setReceiverSmallArea(String receiverSmallArea) {
        this.receiverSmallArea = receiverSmallArea;
    }

    public String getReceiverDoor() {
        return receiverDoor;
    }

    public void setReceiverDoor(String receiverDoor) {
        this.receiverDoor = receiverDoor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
