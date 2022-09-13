package com.syy.chen.bean.jsqd;

public class Jl4101ABean {
    String setlIdMain;
    String inputJson;
    String outputJson;
    String uploadTime;
    String upPt;
    String state;
    String uploadMsg;

    public Jl4101ABean(String setlIdMain, String inputJson, String outputJson, String uploadTime, String upPt, String state, String uploadMsg) {
        this.setlIdMain = setlIdMain;
        this.inputJson = inputJson;
        this.outputJson = outputJson;
        this.uploadTime = uploadTime;
        this.upPt = upPt;
        this.state = state;
        this.uploadMsg = uploadMsg;
    }

    @Override
    public String toString() {
        return "Jl4101ABean{" +
                "setlIdMain='" + setlIdMain + '\'' +
                ", inputJson='" + inputJson + '\'' +
                ", outputJson='" + outputJson + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", upPt='" + upPt + '\'' +
                ", state='" + state + '\'' +
                ", uploadMsg='" + uploadMsg + '\'' +
                '}';
    }
}
