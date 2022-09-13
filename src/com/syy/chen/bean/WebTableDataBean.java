package com.syy.chen.bean;

public class WebTableDataBean {
    int code;
    Object data;
    int count;
    String mesg;
    public WebTableDataBean(int code, Object data, int count, String mesg) {
        this.code = code;
        this.data = data;
        this.count = count;
        this.mesg = mesg;
    }
    public WebTableDataBean() {
    }
    @Override
    public String toString() {
        return "WebTableDataBean{" +
                "code=" + code +
                ", data=" + data +
                ", count=" + count +
                ", mesg='" + mesg + '\'' +
                '}';
    }
}
