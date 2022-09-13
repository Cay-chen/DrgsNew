package com.syy.chen.bean.jsqd;

public class DiseInfo4101ABean {
    private String  diag_type;
    private String  diag_code;
    private String  diag_name;
    private String  adm_cond_type;
    private String  maindiag_flag;

    public DiseInfo4101ABean(String diag_type, String diag_code, String diag_name, String adm_cond_type, String maindiag_flag) {
        this.diag_type = diag_type;
        this.diag_code = diag_code;
        this.diag_name = diag_name;
        this.adm_cond_type = adm_cond_type;
        this.maindiag_flag = maindiag_flag;
    }

    @Override
    public String toString() {
        return "DiseInfo4101ABean{" +
                "diag_type='" + diag_type + '\'' +
                ", diag_code='" + diag_code + '\'' +
                ", diag_name='" + diag_name + '\'' +
                ", adm_cond_type='" + adm_cond_type + '\'' +
                ", maindiag_flag='" + maindiag_flag + '\'' +
                '}';
    }
}
