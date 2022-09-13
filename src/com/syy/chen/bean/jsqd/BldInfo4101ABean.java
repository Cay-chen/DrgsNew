package com.syy.chen.bean.jsqd;

public class BldInfo4101ABean {
    private String  bld_cat;
    private float  bld_amt;
    private String  bld_unt;

    public BldInfo4101ABean(String bld_cat, float bld_amt, String bld_unt) {
        this.bld_cat = bld_cat;
        this.bld_amt = bld_amt;
        this.bld_unt = bld_unt;
    }

    @Override
    public String toString() {
        return "BldInfo4101ABean{" +
                "bld_cat='" + bld_cat + '\'' +
                ", bld_amt=" + bld_amt +
                ", bld_unt='" + bld_unt + '\'' +
                '}';
    }
}
