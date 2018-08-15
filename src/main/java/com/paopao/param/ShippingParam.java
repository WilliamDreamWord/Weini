package com.paopao.param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by joker on 14/08/2018.
 */
public class ShippingParam {

    // TODO: 15/08/2018 notnull message
    @NotNull
    private Integer userId;

    @NotEmpty
    private String receiverName;

    @NotEmpty
    private String receiverMobile;

    @NotEmpty
    private String receiverLargeArea;

    @NotEmpty
    private String receiverMediumArea;

    @NotEmpty
    private String receiverSmallArea;

    @NotEmpty
    private String receiverDoor;

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
}
