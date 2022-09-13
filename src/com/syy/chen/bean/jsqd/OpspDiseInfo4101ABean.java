package com.syy.chen.bean.jsqd;

public class OpspDiseInfo4101ABean {
    private String  diag_name;
    private String  diag_code;
    private String  oprn_oprt_name;
    private String  oprn_oprt_code;

    public OpspDiseInfo4101ABean(String diag_name, String diag_code, String oprn_oprt_name, String oprn_oprt_code) {
        this.diag_name = diag_name;
        this.diag_code = diag_code;
        this.oprn_oprt_name = oprn_oprt_name;
        this.oprn_oprt_code = oprn_oprt_code;
    }

    @Override
    public String toString() {
        return "OpspDiseInfo4101ABean{" +
                "diag_name='" + diag_name + '\'' +
                ", diag_code='" + diag_code + '\'' +
                ", oprn_oprt_name='" + oprn_oprt_name + '\'' +
                ", oprn_oprt_code='" + oprn_oprt_code + '\'' +
                '}';
    }
}
