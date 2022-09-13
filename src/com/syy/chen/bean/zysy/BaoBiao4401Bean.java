package com.syy.chen.bean.zysy;

public class BaoBiao4401Bean {
    private int  DrgsGrabCds;
    private int  DrgsGrabScs;
    private int  DrgsUploadCdsSucc;
    private int  DrgsUploadCdsFail;
    private int  DrgsUploadCdsNo;
    private int  DrgsUploadScsSucc;
    private int  DrgsUploadScsFail;
    private int  DrgsUploadScsNo;
    private int  HisCds;
    private int  HisScs;

    public BaoBiao4401Bean(int drgsGrabCds, int drgsGrabScs, int drgsUploadCdsSucc, int drgsUploadCdsFail, int drgsUploadCdsNo, int drgsUploadScsSucc, int drgsUploadScsFail, int drgsUploadScsNo) {
        DrgsGrabCds = drgsGrabCds;
        DrgsGrabScs = drgsGrabScs;
        DrgsUploadCdsSucc = drgsUploadCdsSucc;
        DrgsUploadCdsFail = drgsUploadCdsFail;
        DrgsUploadCdsNo = drgsUploadCdsNo;
        DrgsUploadScsSucc = drgsUploadScsSucc;
        DrgsUploadScsFail = drgsUploadScsFail;
        DrgsUploadScsNo = drgsUploadScsNo;
    }

    public void setHisCds(int hisCds) {
        HisCds = hisCds;
    }

    public void setHisScs(int hisScs) {
        HisScs = hisScs;
    }

    @Override
    public String toString() {
        return "BaoBiao4401Bean{" +
                "DrgsGrabCds=" + DrgsGrabCds +
                ", DrgsGrabScs=" + DrgsGrabScs +
                ", DrgsUploadCdsSucc=" + DrgsUploadCdsSucc +
                ", DrgsUploadCdsFail=" + DrgsUploadCdsFail +
                ", DrgsUploadCdsNo=" + DrgsUploadCdsNo +
                ", DrgsUploadScsSucc=" + DrgsUploadScsSucc +
                ", DrgsUploadScsFail=" + DrgsUploadScsFail +
                ", DrgsUploadScsNo=" + DrgsUploadScsNo +
                ", HisCds=" + HisCds +
                ", HisScs=" + HisScs +
                '}';
    }
}
