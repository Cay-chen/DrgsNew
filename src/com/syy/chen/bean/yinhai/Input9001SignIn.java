package com.syy.chen.bean.yinhai;

public class Input9001SignIn {
    String ip;
    String mac;
    String opter_no;

    public Input9001SignIn(String ip, String mac, String opter_no) {
        this.ip = ip;
        this.mac = mac;
        this.opter_no = opter_no;
    }

    @Override
    public String toString() {
        return "Input9001SignIn{" +
                "ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", opter_no='" + opter_no + '\'' +
                '}';
    }
}
