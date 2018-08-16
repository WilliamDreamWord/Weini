package com.paopao.common;


public enum JsonResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR");

    private int code;
    private String msg;

    JsonResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
