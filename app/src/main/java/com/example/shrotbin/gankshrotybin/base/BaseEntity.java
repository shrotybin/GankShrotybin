package com.example.shrotbin.gankshrotybin.base;

import com.google.gson.annotations.SerializedName;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/08/01
 *     desc   : base实体类
 *     version: 1.0
 * </pre>
 */

public class BaseEntity<E> {

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private E data;

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
