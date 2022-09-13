package com.syy.chen.bean;

public class SettingBean {
    String grabAutoQd;
    int grabDayQd;
    int grabTimeQd;
    String uploadAutoQd;
    int uploadDayQd;
    int uploadTimeQd;
    String grabAutoSy;
    int grabDaySy;
    int grabTimeSy;
    String uploadAutoSy;
    int uploadDaySy;
    int uploadTimeSy;

    public int getGrabDayQd() {
        return grabDayQd;
    }

    public SettingBean(String grabAutoQd, int grabDayQd, int grabTimeQd, String uploadAutoQd, int uploadDayQd, int uploadTimeQd, String grabAutoSy, int grabDaySy, int grabTimeSy, String uploadAutoSy, int uploadDaySy, int uploadTimeSy) {
        this.grabAutoQd = grabAutoQd;
        this.grabDayQd = grabDayQd;
        this.grabTimeQd = grabTimeQd;
        this.uploadAutoQd = uploadAutoQd;
        this.uploadDayQd = uploadDayQd;
        this.uploadTimeQd = uploadTimeQd;
        this.grabAutoSy = grabAutoSy;
        this.grabDaySy = grabDaySy;
        this.grabTimeSy = grabTimeSy;
        this.uploadAutoSy = uploadAutoSy;
        this.uploadDaySy = uploadDaySy;
        this.uploadTimeSy = uploadTimeSy;
    }

    @Override
    public String toString() {
        return "SettingDao{" +
                "grabAutoQd='" + grabAutoQd + '\'' +
                ", grabDayQd=" + grabDayQd +
                ", grabTimeQd=" + grabTimeQd +
                ", uploadAutoQd='" + uploadAutoQd + '\'' +
                ", uploadDayQd=" + uploadDayQd +
                ", uploadTimeQd=" + uploadTimeQd +
                ", grabAutoSy='" + grabAutoSy + '\'' +
                ", grabDaySy=" + grabDaySy +
                ", grabTimeSy=" + grabTimeSy +
                ", uploadAutoSy='" + uploadAutoSy + '\'' +
                ", uploadDaySy=" + uploadDaySy +
                ", uploadTimeSy=" + uploadTimeSy +
                '}';
    }
}
