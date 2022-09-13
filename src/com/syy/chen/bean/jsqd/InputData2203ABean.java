package com.syy.chen.bean.jsqd;

import java.util.Arrays;

public class InputData2203ABean {
    private DiseInfo2203ABean[] diseinfo;
    private Mdtrtinfo2203ABean mdtrtinfo;

    public DiseInfo2203ABean[] getDiseinfo() {
        return diseinfo;
    }

    public Mdtrtinfo2203ABean getMdtrtinfo() {
        return mdtrtinfo;
    }

    @Override
    public String toString() {
        return "InputData2203ABean{" +
                "diseinfo=" + Arrays.toString(diseinfo) +
                ", mdtrtinfo=" + mdtrtinfo +
                '}';
    }
}
