package com.syy.chen.bean.yinhai;

public class SingInOutTb {
    String sign_no;
    String sign_time;

    public String getSign_no() {
        return sign_no;
    }

    public String getSign_time() {
        return sign_time;
    }

    @Override
    public String toString() {
        return "SingInOutTb{" +
                "sign_no='" + sign_no + '\'' +
                ", sign_time='" + sign_time + '\'' +
                '}';
    }
}
