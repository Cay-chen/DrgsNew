package com.syy.chen.bean.jsqd;

public class IcuInfo4101ABean {
    private String  scs_cutd_ward_type;
    private String  scs_cutd_inpool_time;
    private String  scs_cutd_exit_time;
    private String  scs_cutd_sum_dura;

    public IcuInfo4101ABean(String scs_cutd_ward_type, String scs_cutd_inpool_time, String scs_cutd_exit_time, String scs_cutd_sum_dura) {
        this.scs_cutd_ward_type = scs_cutd_ward_type;
        this.scs_cutd_inpool_time = scs_cutd_inpool_time;
        this.scs_cutd_exit_time = scs_cutd_exit_time;
        this.scs_cutd_sum_dura = scs_cutd_sum_dura;
    }

    @Override
    public String toString() {
        return "IcuInfo4101ABean{" +
                "scs_cutd_ward_type='" + scs_cutd_ward_type + '\'' +
                ", scs_cutd_inpool_time='" + scs_cutd_inpool_time + '\'' +
                ", scs_cutd_exit_time='" + scs_cutd_exit_time + '\'' +
                ", scs_cutd_sum_dura='" + scs_cutd_sum_dura + '\'' +
                '}';
    }
}
