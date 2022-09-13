package com.syy.chen.bean.jsqd;

public class DiseInfo2203ABean {
    private String  diag_code;
    private String  diag_dept;
    private String  diag_name;
    private String  diag_srt_no;
    private String  diag_time;
    private String  diag_type;
    private String  dise_dor_name;
    private String  dise_dor_no;
    private String  vali_flag;

    public String getDiag_code() {
        return diag_code;
    }

    public String getDiag_name() {
        return diag_name;
    }

    @Override
    public String toString() {
        return "DiseInfo2203ABean{" +
                "diag_code='" + diag_code + '\'' +
                ", diag_dept='" + diag_dept + '\'' +
                ", diag_name='" + diag_name + '\'' +
                ", diag_srt_no='" + diag_srt_no + '\'' +
                ", diag_time='" + diag_time + '\'' +
                ", diag_type='" + diag_type + '\'' +
                ", dise_dor_name='" + dise_dor_name + '\'' +
                ", dise_dor_no='" + dise_dor_no + '\'' +
                ", vali_flag='" + vali_flag + '\'' +
                '}';
    }
}
