package com.lwh.learn.security.model.vo;

/**
 * @author lwh
 * @date 2023-11-11 16:04:19
 * @describe --
 */
public class RespBean <T>{

    private String msg;

    private T data;

    public static <T> RespBean<T> ok(String mag, T data) {
        RespBean<T> respBean = new RespBean<T>();
        respBean.setMsg(mag);
        respBean.setData(data);
        return respBean;
    }

    public static <T> RespBean<T> error(String msg) {
        RespBean<T> respBean = new RespBean<T>();
        respBean.setMsg(msg);
        return respBean;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
