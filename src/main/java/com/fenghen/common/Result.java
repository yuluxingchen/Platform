package com.fenghen.common;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean flag;   //后端返回结果
    private Object data;    //返回数据对象
    private String msg;     //发生异常的错误信息

    //无参构造方法
    public Result() {}

    //有参构造
    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    //读写方法
    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
