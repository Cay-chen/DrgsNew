package com.syy.chen.bean.zysy;

public class IcuInfo4401Bean {
    String icu_code;
    String inpool_icu_time;
    String out_icu_time;
    String medins_orgcode;
    String nurscare_lv_code;
    String nurscare_lv_name;
    String nurscare_days;
    String back_icu;
    String vali_flag;
    String ipt_medcas_hmpg_sn;
    String mdtrt_sn;
    String fixmedins_code;

    public IcuInfo4401Bean(String icu_code, String inpool_icu_time, String out_icu_time, String medins_orgcode, String nurscare_lv_code, String nurscare_lv_name, String nurscare_days, String back_icu, String vali_flag, String ipt_medcas_hmpg_sn, String mdtrt_sn, String fixmedins_code) {
        this.icu_code = icu_code;
        this.inpool_icu_time = inpool_icu_time;
        this.out_icu_time = out_icu_time;
        this.medins_orgcode = medins_orgcode;
        this.nurscare_lv_code = nurscare_lv_code;
        this.nurscare_lv_name = nurscare_lv_name;
        this.nurscare_days = nurscare_days;
        this.back_icu = back_icu;
        this.vali_flag = vali_flag;
        this.ipt_medcas_hmpg_sn = ipt_medcas_hmpg_sn;
        this.mdtrt_sn = mdtrt_sn;
        this.fixmedins_code = fixmedins_code;
    }

    @Override
    public String toString() {
        return "IcuInfo4401Bean{" +
                "icu_code='" + icu_code + '\'' +
                ", inpool_icu_time='" + inpool_icu_time + '\'' +
                ", out_icu_time='" + out_icu_time + '\'' +
                ", medins_orgcode='" + medins_orgcode + '\'' +
                ", nurscare_lv_code='" + nurscare_lv_code + '\'' +
                ", nurscare_lv_name='" + nurscare_lv_name + '\'' +
                ", nurscare_days='" + nurscare_days + '\'' +
                ", back_icu='" + back_icu + '\'' +
                ", vali_flag='" + vali_flag + '\'' +
                ", ipt_medcas_hmpg_sn='" + ipt_medcas_hmpg_sn + '\'' +
                ", mdtrt_sn='" + mdtrt_sn + '\'' +
                ", fixmedins_code='" + fixmedins_code + '\'' +
                '}';
    }
}
