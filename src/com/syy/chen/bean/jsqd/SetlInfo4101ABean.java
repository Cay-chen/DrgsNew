package com.syy.chen.bean.jsqd;

import com.syy.chen.Utils;

import java.text.ParseException;

public class SetlInfo4101ABean {
    private String acp_medins_name;
    private String acp_optins_code;
    private String adm_time;
    private String adm_way;
    private String bill_code;
    private String bill_no;
    private String biz_sn;
    private String chfpdr_code;
    private String coner_addr;
    private String coner_name;
    private String coner_tel;
    private String curr_addr;
    private String days_rinp_flag_31;
    private String days_rinp_pup_31;
    private String dcla_time;
    private String dscg_caty;
    private String dscg_time;
    private String dscg_way;
    private String emp_addr;
    private String emp_name;
    private String emp_tel;
    private String grap_time;
    private String hi_no;
    private String hi_paymtd;
    private String insuplc_admdvs;
    private String lv1_nurscare_days;
    private String lv3_nurscare_days;
    private String mdtrt_id;
    private String medcasno;
    private String medical_type;
    private String medins_fill_dept;
    private String medins_fill_psn;
    private String ntly;
    private String nwb_admtype;
    private String nwbadmwt;
    private String nwbbirwt;
    private String opsp_diag_caty;
    private String opsp_mdtrt_date;
    private String otp_wm_dise;
    private String otptcmdise;
    private String pact_code;
    private String patn_rlts;
    private String poscode;
    private String prfs;
    private String psn_no;
    private String pwcry_afadm_coma_dura;
    private String pwcry_bfadm_coma_dura;
    private String refldept_dept;
    private String resp_nurs_code;
    /*
        private String  rn;
    */
    private String scd_nurscare_days;
    private String setl_begn_date;
    private String setl_end_date;
    private String setl_id;
    private String setl_id_main;
    private String setl_list_id_cds;
    private String setl_list_id_scs;
    private String spga_nurscare_days;
    private String stas_type;
    private String tcmdisecode;
    private String trans_type;
    private String trt_type;
    private String type_flag;
    private String type_mz;
    private String upload_state_cds;
    private String upload_state_scs;
    private String upload_time_cds;
    private String upload_time_scs;
    private String vent_used_dura;
    private String wm_dise_code;
    private String invoice_no;
    private String setl_date;
    private String upload_time;
    private String upload_state;
    private String setl_list_id;

    public SetlInfo4101ABean(String acp_medins_name, String acp_optins_code, String adm_time, String adm_way, String bill_code, String bill_no, String biz_sn, String chfpdr_code, String coner_addr, String coner_name, String coner_tel, String curr_addr, String days_rinp_flag_31, String days_rinp_pup_31, String dcla_time, String dscg_caty, String dscg_time, String dscg_way, String emp_addr, String emp_name, String emp_tel, String grap_time, String hi_no, String hi_paymtd, String insuplc_admdvs, String lv1_nurscare_days, String lv3_nurscare_days, String mdtrt_id, String medcasno, String medical_type, String medins_fill_dept, String medins_fill_psn, String ntly, String nwb_admtype, String nwbadmwt, String nwbbirwt, String opsp_diag_caty, String opsp_mdtrt_date, String otp_wm_dise, String otptcmdise, String pact_code, String patn_rlts, String poscode, String prfs, String psn_no, String pwcry_afadm_coma_dura, String pwcry_bfadm_coma_dura, String refldept_dept, String resp_nurs_code, String scd_nurscare_days, String setl_begn_date, String setl_end_date, String setl_id, String setl_id_main, String setl_list_id_cds, String setl_list_id_scs, String spga_nurscare_days, String stas_type, String tcmdisecode, String trans_type, String trt_type, String type_flag, String type_mz, String upload_state_cds, String upload_state_scs, String upload_time_cds, String upload_time_scs, String vent_used_dura, String wm_dise_code, String invoice_no, String setl_date) throws ParseException {
        this.acp_medins_name = acp_medins_name;
        this.acp_optins_code = acp_optins_code;
        this.adm_time = adm_time;
        this.adm_way = adm_way;
        this.bill_code = bill_code;
        this.bill_no = bill_no;
        this.biz_sn = biz_sn;
        this.chfpdr_code = chfpdr_code;
        this.coner_addr = coner_addr;
        this.coner_name = coner_name;
        this.coner_tel = coner_tel;
        this.curr_addr = curr_addr;
        this.days_rinp_flag_31 = days_rinp_flag_31;
        this.days_rinp_pup_31 = days_rinp_pup_31;
        this.dcla_time = dcla_time;
        this.dscg_caty = dscg_caty;
        this.dscg_time = dscg_time;
        this.dscg_way = dscg_way;
        this.emp_addr = emp_addr;
        this.emp_name = emp_name;
        this.emp_tel = emp_tel;
        this.grap_time = grap_time;
        this.hi_no = hi_no;
        this.hi_paymtd = hi_paymtd;
        this.insuplc_admdvs = insuplc_admdvs;
        this.lv1_nurscare_days = lv1_nurscare_days;
        this.lv3_nurscare_days = lv3_nurscare_days;
        this.mdtrt_id = mdtrt_id;
        this.medcasno = medcasno;
        this.medical_type = medical_type;
        this.medins_fill_dept = medins_fill_dept;
        this.medins_fill_psn = medins_fill_psn;
        this.ntly = ntly;
        this.nwb_admtype = nwb_admtype;
        this.nwbadmwt = nwbadmwt;
        this.nwbbirwt = nwbbirwt;
        this.opsp_diag_caty = opsp_diag_caty;
        this.opsp_mdtrt_date = opsp_mdtrt_date;
        this.otp_wm_dise = otp_wm_dise;
        this.otptcmdise = otptcmdise;
        this.pact_code = pact_code;
        this.patn_rlts = patn_rlts;
        this.poscode = poscode;
        this.prfs = prfs;
        this.psn_no = psn_no;
        this.pwcry_afadm_coma_dura = pwcry_afadm_coma_dura;
        this.pwcry_bfadm_coma_dura = pwcry_bfadm_coma_dura;
        this.refldept_dept = refldept_dept;
        this.resp_nurs_code = resp_nurs_code;
/*
        this.rn = rn;
*/
        this.scd_nurscare_days = scd_nurscare_days;
        this.setl_begn_date = setl_begn_date;
        this.setl_end_date = setl_end_date;
        this.setl_id = setl_id;
        this.setl_id_main = setl_id_main;
        this.setl_list_id_cds = setl_list_id_cds;
        this.setl_list_id_scs = setl_list_id_scs;
        this.spga_nurscare_days = spga_nurscare_days;
        this.stas_type = stas_type;
        this.tcmdisecode = tcmdisecode;
        this.trans_type = trans_type;
        this.trt_type = trt_type;
        this.type_flag = type_flag;
        this.type_mz = type_mz;
        this.upload_state_cds = upload_state_cds;
        this.upload_state_scs = upload_state_scs;
        this.upload_time_cds = upload_time_cds;
        this.upload_time_scs = upload_time_scs;
        this.vent_used_dura = vent_used_dura;
        this.wm_dise_code = wm_dise_code;
        this.invoice_no = invoice_no;
        this.setl_date = setl_date;
    }

    public SetlInfo4101ABean(String psn_no, String setl_id, String medcasno, String mdtrt_id, String dcla_time, String type_mz, String insuplc_admdvs, String pact_code, String trans_type, String grap_time, String upload_time_cds, String upload_state_cds, String setl_list_id_cds, String upload_time_scs, String upload_state_scs, String setl_list_id_scs, String type_flag, String invoice_no, String setl_date) throws ParseException {
        this.psn_no = psn_no;
        this.setl_id = setl_id;
        this.medcasno = medcasno;
        this.mdtrt_id = mdtrt_id;
        if (dcla_time != null && !dcla_time.equals("")) {
            this.dcla_time = Utils.SqlTimeToTime(dcla_time);
        }
        this.type_mz = type_mz;
        this.insuplc_admdvs = insuplc_admdvs;
        this.pact_code = pact_code;
        this.trans_type = trans_type;
        this.grap_time = grap_time;
        if (grap_time != null && !grap_time.equals("")) {
            this.grap_time = Utils.SqlTimeToTime(grap_time);
        }
        if (upload_time_cds != null && !upload_time_cds.equals("")) {
            this.upload_time_cds = Utils.SqlTimeToTime(upload_time_cds);
        }
        this.upload_state_cds = upload_state_cds;
        this.setl_list_id_cds = setl_list_id_cds;
        if (upload_time_scs != null && !upload_time_scs.equals("")) {
            this.upload_time_scs = Utils.SqlTimeToTime(upload_time_scs);
        }
        this.upload_state_scs = upload_state_scs;
        this.setl_list_id_scs = setl_list_id_scs;
        this.type_flag = type_flag;
        this.invoice_no = invoice_no;
        if (setl_date != null && !setl_date.equals("")) {
            this.setl_date = Utils.SqlTimeToDate(setl_date);
        }
    }

    public SetlInfo4101ABean(String psn_no, String mdtrt_id, String setl_id, String hi_no, String medcasno, String dcla_time, String ntly, String prfs, String curr_addr, String emp_name, String emp_addr, String emp_tel, String poscode, String coner_name, String patn_rlts, String coner_addr, String coner_tel, String nwb_admtype, String nwbbirwt, String nwbadmwt, String opsp_diag_caty, String opsp_mdtrt_date, String adm_way, String trt_type, String adm_time, String refldept_dept, String dscg_time, String dscg_caty, String otp_wm_dise, String wm_dise_code, String otptcmdise, String tcmdisecode, String vent_used_dura, String pwcry_bfadm_coma_dura, String pwcry_afadm_coma_dura, String spga_nurscare_days, String lv1_nurscare_days, String scd_nurscare_days, String lv3_nurscare_days, String dscg_way, String acp_medins_name, String acp_optins_code, String bill_code, String bill_no, String biz_sn, String days_rinp_flag_31, String days_rinp_pup_31, String chfpdr_code, String setl_begn_date, String setl_end_date, String medins_fill_dept, String medins_fill_psn, String resp_nurs_code, String stas_type, String hi_paymtd) {
        this.acp_medins_name = acp_medins_name;
        this.acp_optins_code = acp_optins_code;
        this.adm_time = adm_time;
        this.adm_way = adm_way;
        this.bill_code = bill_code;
        this.bill_no = bill_no;
        this.biz_sn = biz_sn;
        this.chfpdr_code = chfpdr_code;
        this.coner_addr = coner_addr;
        this.coner_name = coner_name;
        this.coner_tel = coner_tel;
        this.curr_addr = curr_addr;
        this.days_rinp_flag_31 = days_rinp_flag_31;
        this.days_rinp_pup_31 = days_rinp_pup_31;
        this.dcla_time = dcla_time;
        this.dscg_caty = dscg_caty;
        this.dscg_time = dscg_time;
        this.dscg_way = dscg_way;
        this.emp_addr = emp_addr;
        this.emp_name = emp_name;
        this.emp_tel = emp_tel;
        this.hi_no = hi_no;
        this.hi_paymtd = hi_paymtd;
        this.lv1_nurscare_days = lv1_nurscare_days;
        this.lv3_nurscare_days = lv3_nurscare_days;
        this.mdtrt_id = mdtrt_id;
        this.medcasno = medcasno;
        this.medins_fill_dept = medins_fill_dept;
        this.medins_fill_psn = medins_fill_psn;
        this.ntly = ntly;
        this.nwb_admtype = nwb_admtype;
        this.nwbadmwt = nwbadmwt;
        this.nwbbirwt = nwbbirwt;
        this.opsp_diag_caty = opsp_diag_caty;
        this.opsp_mdtrt_date = opsp_mdtrt_date;
        this.otp_wm_dise = otp_wm_dise;
        this.otptcmdise = otptcmdise;
        this.patn_rlts = patn_rlts;
        this.poscode = poscode;
        this.prfs = prfs;
        this.psn_no = psn_no;
        this.pwcry_afadm_coma_dura = pwcry_afadm_coma_dura;
        this.pwcry_bfadm_coma_dura = pwcry_bfadm_coma_dura;
        this.refldept_dept = refldept_dept;
        this.resp_nurs_code = resp_nurs_code;
        this.scd_nurscare_days = scd_nurscare_days;
        this.setl_begn_date = setl_begn_date;
        this.setl_end_date = setl_end_date;
        this.setl_id = setl_id;
        this.spga_nurscare_days = spga_nurscare_days;
        this.stas_type = stas_type;
        this.tcmdisecode = tcmdisecode;
        this.trt_type = trt_type;
        this.vent_used_dura = vent_used_dura;
        this.wm_dise_code = wm_dise_code;
    }

    public SetlInfo4101ABean(String setl_id_main, String type_flag, String type_mz,String insuplc_admdvs) {
        this.setl_id_main = setl_id_main;
        this.type_flag = type_flag;
        this.type_mz = type_mz;
        this.insuplc_admdvs = insuplc_admdvs;
    }

    public String getUpload_time_cds() {
        return upload_time_cds;
    }

    public String getUpload_state_cds() {
        return upload_state_cds;
    }

    public String getSetl_list_id_cds() {
        return setl_list_id_cds;
    }

    public String getUpload_time_scs() {
        return upload_time_scs;
    }

    public String getUpload_state_scs() {
        return upload_state_scs;
    }

    public String getSetl_list_id_scs() {
        return setl_list_id_scs;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public void setUpload_state(String upload_state) {
        this.upload_state = upload_state;
    }

    public void setSetl_list_id(String setl_list_id) {
        this.setl_list_id = setl_list_id;
    }

    public String getType_flag() {
        return type_flag;
    }

    public String getUpload_state() {
        return upload_state;
    }

    public String getSetl_id_main() {
        return setl_id_main;
    }

    public String getTrt_type() {
        return trt_type;
    }

    public String getType_mz() {
        return type_mz;
    }

    public String getInsuplc_admdvs() {
        return insuplc_admdvs;
    }

    @Override
    public String toString() {
        return "Setl4101ABean{" +
                "acp_medins_name='" + acp_medins_name + '\'' +
                ", acp_optins_code='" + acp_optins_code + '\'' +
                ", adm_time='" + adm_time + '\'' +
                ", adm_way='" + adm_way + '\'' +
                ", bill_code='" + bill_code + '\'' +
                ", bill_no='" + bill_no + '\'' +
                ", biz_sn='" + biz_sn + '\'' +
                ", chfpdr_code='" + chfpdr_code + '\'' +
                ", coner_addr='" + coner_addr + '\'' +
                ", coner_name='" + coner_name + '\'' +
                ", coner_tel='" + coner_tel + '\'' +
                ", curr_addr='" + curr_addr + '\'' +
                ", days_rinp_flag_31='" + days_rinp_flag_31 + '\'' +
                ", days_rinp_pup_31='" + days_rinp_pup_31 + '\'' +
                ", dcla_time='" + dcla_time + '\'' +
                ", dscg_caty='" + dscg_caty + '\'' +
                ", dscg_time='" + dscg_time + '\'' +
                ", dscg_way='" + dscg_way + '\'' +
                ", emp_addr='" + emp_addr + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_tel='" + emp_tel + '\'' +
                ", grap_time='" + grap_time + '\'' +
                ", hi_no='" + hi_no + '\'' +
                ", hi_paymtd='" + hi_paymtd + '\'' +
                ", insuplc_admdvs='" + insuplc_admdvs + '\'' +
                ", lv1_nurscare_days='" + lv1_nurscare_days + '\'' +
                ", lv3_nurscare_days='" + lv3_nurscare_days + '\'' +
                ", mdtrt_id='" + mdtrt_id + '\'' +
                ", medcasno='" + medcasno + '\'' +
                ", medical_type='" + medical_type + '\'' +
                ", medins_fill_dept='" + medins_fill_dept + '\'' +
                ", medins_fill_psn='" + medins_fill_psn + '\'' +
                ", ntly='" + ntly + '\'' +
                ", nwb_admtype='" + nwb_admtype + '\'' +
                ", nwbadmwt='" + nwbadmwt + '\'' +
                ", nwbbirwt='" + nwbbirwt + '\'' +
                ", opsp_diag_caty='" + opsp_diag_caty + '\'' +
                ", opsp_mdtrt_date='" + opsp_mdtrt_date + '\'' +
                ", otp_wm_dise='" + otp_wm_dise + '\'' +
                ", otptcmdise='" + otptcmdise + '\'' +
                ", pact_code='" + pact_code + '\'' +
                ", patn_rlts='" + patn_rlts + '\'' +
                ", poscode='" + poscode + '\'' +
                ", prfs='" + prfs + '\'' +
                ", psn_no='" + psn_no + '\'' +
                ", pwcry_afadm_coma_dura='" + pwcry_afadm_coma_dura + '\'' +
                ", pwcry_bfadm_coma_dura='" + pwcry_bfadm_coma_dura + '\'' +
                ", refldept_dept='" + refldept_dept + '\'' +
                ", resp_nurs_code='" + resp_nurs_code + '\'' +
/*
                ", rn='" + rn + '\'' +
*/
                ", scd_nurscare_days='" + scd_nurscare_days + '\'' +
                ", setl_begn_date='" + setl_begn_date + '\'' +
                ", setl_end_date='" + setl_end_date + '\'' +
                ", setl_id='" + setl_id + '\'' +
                ", setl_id_main='" + setl_id_main + '\'' +
                ", setl_list_id_cds='" + setl_list_id_cds + '\'' +
                ", setl_list_id_scs='" + setl_list_id_scs + '\'' +
                ", spga_nurscare_days='" + spga_nurscare_days + '\'' +
                ", stas_type='" + stas_type + '\'' +
                ", tcmdisecode='" + tcmdisecode + '\'' +
                ", trans_type='" + trans_type + '\'' +
                ", trt_type='" + trt_type + '\'' +
                ", type_flag='" + type_flag + '\'' +
                ", type_mz='" + type_mz + '\'' +
                ", upload_state_cds='" + upload_state_cds + '\'' +
                ", upload_state_scs='" + upload_state_scs + '\'' +
                ", upload_time_cds='" + upload_time_cds + '\'' +
                ", upload_time_scs='" + upload_time_scs + '\'' +
                ", vent_used_dura='" + vent_used_dura + '\'' +
                ", wm_dise_code='" + wm_dise_code + '\'' +
                ", invoice_no='" + invoice_no + '\'' +
                ", setl_date='" + setl_date + '\'' +
                ", upload_time='" + upload_time + '\'' +
                ", upload_state='" + upload_state + '\'' +
                ", setl_list_id='" + setl_list_id + '\'' +
                '}';
    }
}
