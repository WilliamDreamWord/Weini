package com.paopao.po;

import java.util.Date;

public class Shipping {
    private Integer id;

    private Integer userId;

    private String receiverName;

    private String receiverMobile;

    private String receiverLargeArea;

    private String receiverMediumArea;

    private String receiverSmallArea;

    private String receiverDoor;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Shipping(Integer id, Integer userId, String receiverName, String receiverMobile, String receiverLargeArea, String receiverMediumArea, String receiverSmallArea, String receiverDoor, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.receiverName = receiverName;
        this.receiverMobile = receiverMobile;
        this.receiverLargeArea = receiverLargeArea;
        this.receiverMediumArea = receiverMediumArea;
        this.receiverSmallArea = receiverSmallArea;
        this.receiverDoor = receiverDoor;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Shipping() {
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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getReceiverLargeArea() {
        return receiverLargeArea;
    }

    public void setReceiverLargeArea(String receiverLargeArea) {
        this.receiverLargeArea = receiverLargeArea == null ? null : receiverLargeArea.trim();
    }

    public String getReceiverMediumArea() {
        return receiverMediumArea;
    }

    public void setReceiverMediumArea(String receiverMediumArea) {
        this.receiverMediumArea = receiverMediumArea == null ? null : receiverMediumArea.trim();
    }

    public String getReceiverSmallArea() {
        return receiverSmallArea;
    }

    public void setReceiverSmallArea(String receiverSmallArea) {
        this.receiverSmallArea = receiverSmallArea == null ? null : receiverSmallArea.trim();
    }

    public String getReceiverDoor() {
        return receiverDoor;
    }

    public void setReceiverDoor(String receiverDoor) {
        this.receiverDoor = receiverDoor == null ? null : receiverDoor.trim();
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

    @Override
    public String toString() {
        return "Shipping{" +
                "id=" + id +
                ", userId=" + userId +
                ", receiverName='" + receiverName + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverLargeArea='" + receiverLargeArea + '\'' +
                ", receiverMediumArea='" + receiverMediumArea + '\'' +
                ", receiverSmallArea='" + receiverSmallArea + '\'' +
                ", receiverDoor='" + receiverDoor + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}