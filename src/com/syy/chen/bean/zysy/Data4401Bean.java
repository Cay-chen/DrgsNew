package com.syy.chen.bean.zysy;

import com.syy.chen.bean.jsqd.*;

import java.util.ArrayList;

public class Data4401Bean {
    private BaseInfoBean baseinfo;
    private ArrayList<DiseInfo4401Bean> diseinfo;
    private ArrayList<OprnInfo4401Bean> oprninfo;
    private ArrayList<IcuInfo4401Bean> icuinfo;


    public Data4401Bean(BaseInfoBean baseinfo, ArrayList<DiseInfo4401Bean> diseinfo, ArrayList<OprnInfo4401Bean> oprninfo, ArrayList<IcuInfo4401Bean> icuinfo) {
        this.baseinfo = baseinfo;
        this.diseinfo = diseinfo;
        this.oprninfo = oprninfo;
        this.icuinfo = icuinfo;
    }

    @Override
    public String toString() {
        return "Data4401Bean{" +
                "baseinfo=" + baseinfo +
                ", diseinfo=" + diseinfo +
                ", oprninfo=" + oprninfo +
                ", icuinfo=" + icuinfo +
                '}';
    }
}
