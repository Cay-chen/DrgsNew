package com.syy.chen.bean.yinhai;

public class YinHaiDataBean {
    String infno;
    String msgid;
    String mdtrtarea_admvs;
    String insuplc_admdvs;
    String recer_sys_code;
    String dev_no;
    String dev_safe_info;
    String cainfo;
    String signtype;
    String infver;
    String opter_type;
    String opter;
    String opter_name;
    String inf_time;
    String fixmedins_code;
    String fixmedins_name;
    String sign_no;
    Object input;

    public YinHaiDataBean() {
    }

    public void setInfno(String infno) {
        this.infno = infno;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public void setMdtrtarea_admvs(String mdtrtarea_admvs) {
        this.mdtrtarea_admvs = mdtrtarea_admvs;
    }

    public void setInsuplc_admdvs(String insuplc_admdvs) {
        this.insuplc_admdvs = insuplc_admdvs;
    }

    public void setRecer_sys_code(String recer_sys_code) {
        this.recer_sys_code = recer_sys_code;
    }

    public void setDev_no(String dev_no) {
        this.dev_no = dev_no;
    }

    public void setDev_safe_info(String dev_safe_info) {
        this.dev_safe_info = dev_safe_info;
    }

    public void setCainfo(String cainfo) {
        this.cainfo = cainfo;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public void setInfver(String infver) {
        this.infver = infver;
    }

    public void setOpter_type(String opter_type) {
        this.opter_type = opter_type;
    }

    public void setOpter(String opter) {
        this.opter = opter;
    }

    public void setOpter_name(String opter_name) {
        this.opter_name = opter_name;
    }

    public void setInf_time(String inf_time) {
        this.inf_time = inf_time;
    }

    public void setFixmedins_code(String fixmedins_code) {
        this.fixmedins_code = fixmedins_code;
    }

    public void setFixmedins_name(String fixmedins_name) {
        this.fixmedins_name = fixmedins_name;
    }

    public void setSign_no(String sign_no) {
        this.sign_no = sign_no;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "YinHaiDataBean{" +
                "infno='" + infno + '\'' +
                ", msgid='" + msgid + '\'' +
                ", mdtrtarea_admvs='" + mdtrtarea_admvs + '\'' +
                ", insuplc_admdvs='" + insuplc_admdvs + '\'' +
                ", recer_sys_code='" + recer_sys_code + '\'' +
                ", dev_no='" + dev_no + '\'' +
                ", dev_safe_info='" + dev_safe_info + '\'' +
                ", cainfo='" + cainfo + '\'' +
                ", signtype='" + signtype + '\'' +
                ", infver='" + infver + '\'' +
                ", opter_type='" + opter_type + '\'' +
                ", opter='" + opter + '\'' +
                ", opter_name='" + opter_name + '\'' +
                ", inf_time='" + inf_time + '\'' +
                ", fixmedins_code='" + fixmedins_code + '\'' +
                ", fixmedins_name='" + fixmedins_name + '\'' +
                ", sign_no='" + sign_no + '\'' +
                ", input=" + input +
                '}';
    }
}
