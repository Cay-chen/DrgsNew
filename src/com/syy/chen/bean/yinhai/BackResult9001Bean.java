package com.syy.chen.bean.yinhai;

public class BackResult9001Bean {
    OutPut9001Bean output;
    int infcode;
    String warn_msg;
    String cainfo;
    String err_msg;
    String refmsg_time;
    String signtype;
    String respond_time;
    String inf_refmsgid;

    public OutPut9001Bean getOutput() {
        return output;
    }

    public int getInfcode() {
        return infcode;
    }

    public String getWarn_msg() {
        return warn_msg;
    }

    public String getCainfo() {
        return cainfo;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public String getRefmsg_time() {
        return refmsg_time;
    }

    public String getSigntype() {
        return signtype;
    }

    public String getRespond_time() {
        return respond_time;
    }

    public String getInf_refmsgid() {
        return inf_refmsgid;
    }

    @Override
    public String toString() {
        return "BackResultBean{" +
                "output=" + output +
                ", infcode='" + infcode + '\'' +
                ", warn_msg='" + warn_msg + '\'' +
                ", cainfo='" + cainfo + '\'' +
                ", err_msg='" + err_msg + '\'' +
                ", refmsg_time='" + refmsg_time + '\'' +
                ", signtype='" + signtype + '\'' +
                ", respond_time='" + respond_time + '\'' +
                ", inf_refmsgid='" + inf_refmsgid + '\'' +
                '}';
    }
}

