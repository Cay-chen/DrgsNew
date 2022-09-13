package com.syy.chen.bean.jsqd;

import java.util.ArrayList;

public class Data4101ABean {
    private SetlInfo4101ABean setlinfo;
    private ArrayList<DiseInfo4101ABean> diseinfo;
    private ArrayList<OprnInfo4101ABean> oprninfo;
    private ArrayList<IcuInfo4101ABean> icuinfo;
    private ArrayList<BldInfo4101ABean> bldinfo;
    private ArrayList<OpspDiseInfo4101ABean> opspdiseinfo;

    public Data4101ABean(SetlInfo4101ABean setlinfo, ArrayList<DiseInfo4101ABean> diseinfo, ArrayList<OprnInfo4101ABean> oprninfo, ArrayList<IcuInfo4101ABean> icuinfo, ArrayList<BldInfo4101ABean> bldinfo, ArrayList<OpspDiseInfo4101ABean> opspdiseinfo) {
        this.setlinfo = setlinfo;
        this.diseinfo = diseinfo;
        this.oprninfo = oprninfo;
        this.icuinfo = icuinfo;
        this.bldinfo = bldinfo;
        this.opspdiseinfo = opspdiseinfo;
    }

    @Override
    public String toString() {
        return "CheckData4101ABean{" +
                "setlinfo=" + setlinfo +
                ", diseinfo=" + diseinfo +
                ", oprninfo=" + oprninfo +
                ", icuinfo=" + icuinfo +
                ", bldinfo=" + bldinfo +
                ", opspdiseinfo=" + opspdiseinfo +
                '}';
    }
}
