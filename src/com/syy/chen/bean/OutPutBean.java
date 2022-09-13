package com.syy.chen.bean;

import com.syy.chen.config;

public class OutPutBean {
    int state;
    String msg;
    Object data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OutPutBean(int state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }
    public OutPutBean() {
        this.state = config.FAIL_STATE;
        this.msg = config.FAIL_MSG;
    }
    @Override
    public String toString() {
        return "OutPutBean{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
