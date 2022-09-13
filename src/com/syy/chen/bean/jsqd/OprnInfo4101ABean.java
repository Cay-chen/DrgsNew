package com.syy.chen.bean.jsqd;

public class OprnInfo4101ABean {
    private String oprn_oprt_type;
    private String oprn_oprt_name;
    private String oprn_oprt_code;
    private String anst_way;
    private String oper_dr_code;
    private String anst_dr_code;
    private String oprn_oprt_begntime;
    private String oprn_oprt_endtime;
    private String anst_begntime;
    private String anst_endtime;

    public OprnInfo4101ABean(String oprn_oprt_type, String oprn_oprt_name, String oprn_oprt_code, String anst_way, String oper_dr_code, String anst_dr_code, String oprn_oprt_begntime, String oprn_oprt_endtime, String anst_begntime, String anst_endtime) {
        this.oprn_oprt_type = oprn_oprt_type;
        this.oprn_oprt_name = oprn_oprt_name;
        this.oprn_oprt_code = oprn_oprt_code;
        this.anst_way = anst_way;
        this.oper_dr_code = oper_dr_code;
        this.anst_dr_code = anst_dr_code;
        this.oprn_oprt_begntime = oprn_oprt_begntime;
        this.oprn_oprt_endtime = oprn_oprt_endtime;
        this.anst_begntime = anst_begntime;
        this.anst_endtime = anst_endtime;
    }

    @Override
    public String toString() {
        return "OprnInfo4101ABean{" +
                "oprn_oprt_type='" + oprn_oprt_type + '\'' +
                ", oprn_oprt_name='" + oprn_oprt_name + '\'' +
                ", oprn_oprt_code='" + oprn_oprt_code + '\'' +
                ", anst_way='" + anst_way + '\'' +
                ", oper_dr_code='" + oper_dr_code + '\'' +
                ", anst_dr_code='" + anst_dr_code + '\'' +
                ", oprn_oprt_begntime='" + oprn_oprt_begntime + '\'' +
                ", oprn_oprt_endtime='" + oprn_oprt_endtime + '\'' +
                ", anst_begntime='" + anst_begntime + '\'' +
                ", anst_endtime='" + anst_endtime + '\'' +
                '}';
    }
}
