package com.paopao.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    private JsonResponse(int code) {
        this.code = code;
    }

    private JsonResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private JsonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private JsonResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == JsonResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> JsonResponse<T> createBySuccess() {
        return new JsonResponse<T>(JsonResponseCode.SUCCESS.getCode());
    }

    public static <T> JsonResponse<T> createBySuccessMsg(String msg) {
        return new JsonResponse<T>(JsonResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> JsonResponse<T> createBySuccess(T data) {
        return new JsonResponse<T>(JsonResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> JsonResponse<T> createBySuccess(String msg, T data) {
        return new JsonResponse<T>(JsonResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> JsonResponse createByError() {
        return new JsonResponse<T>(JsonResponseCode.ERROR.getCode());
    }

    public static <T> JsonResponse<T> createByErrorMsg(String msg) {
        return new JsonResponse<T>(JsonResponseCode.ERROR.getCode(), msg);
    }

    public static <T> JsonResponse<T> createByOthersMsg(int code, String msg) {
        return new JsonResponse<T>(code, msg);
    }


}
