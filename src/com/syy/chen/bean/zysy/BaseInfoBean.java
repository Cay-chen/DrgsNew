package com.syy.chen.bean.zysy;

import com.syy.chen.Utils;

import java.text.ParseException;

public class BaseInfoBean {
    String mdtrt_sn;
    String mdtrt_id;
    String psn_no;
    String patn_ipt_cnt;
    String ipt_no;
    String medcasno;
    String psn_name;
    String gend;
    String brdy;
    String ntly;
    String ntly_name;
    float nwb_bir_wt;
    float nwb_adm_wt;
    String birplc;
    String napl;
    String naty_name;
    String naty;
    String certno;
    String prfs;
    String mrg_stas;
    String curr_addr_poscode;
    String curr_addr;
    String psn_tel;
    String resd_addr_prov;
    String resd_addr_city;
    String resd_addr_coty;
    String resd_addr_subd;
    String resd_addr_vil;
    String resd_addr_housnum;
    String resd_addr_poscode;
    String resd_addr;
    String empr_tel;
    String empr_poscode;
    String empr_addr;
    String coner_tel;
    String coner_name;
    String coner_addr;
    String coner_rlts_code;
    String adm_way_name;
    String adm_way_code;
    String trt_type_name;
    String trt_type;
    String adm_caty;
    String adm_ward;
    String adm_date;
    String dscg_date;
    String dscg_caty;
    String refldeptcatyname;
    String dscg_ward;
    int ipt_days;
    String drug_dicm_flag;
    String dicm_drug_name;
    String die_autp_flag;
    String abo_code;
    String abo_name;
    String rh_code;
    String rh_name;
    String die_flag;
    String deptdrt_name;
    String chfdr_name;
    String atddr_name;
    String chfpdr_name;
    String ipt_dr_name;
    String resp_nurs_name;
    String train_dr_name;
    String intn_dr_name;
    String codr_name;
    String qltctrl_dr_name;
    String qltctrl_nurs_name;
    String medcas_qlt_name;
    String medcas_qlt_code;
    String qltctrl_date;
    String dscg_way_name;
    String dscg_way;
    String acp_medins_code;
    String acp_medins_name;
    String dscg_31days_rinp_flag;
    String dscg_31days_rinp_pup;
    String damg_intx_ext_rea;
    String damg_intx_ext_rea_disecode;
    String brn_damg_bfadm_coma_dura;
    String brn_damg_afadm_coma_dura;
    String vent_used_dura;
    String cnfm_date;
    String patn_dise_diag_crsp;
    String patn_dise_diag_crsp_code;
    String ipt_patn_diag_inscp;
    String ipt_patn_diag_inscp_code;
    String dscg_trt_rslt;
    String dscg_trt_rslt_code;
    String medins_orgcode;
    float age;
    String aise;
    String pote_intn_dr_name;
    String hbsag;
    String hcvab;
    String hivab;
    int resc_cnt;
    int resc_succ_cnt;
    String hosp_dise_fsttime;
    String hif_pay_way_name;
    String hif_pay_way_code;
    String med_fee_paymtd_name;
    String medfee_paymtd_code;
    float selfpay_amt;
    float medfee_sumamt;
    float ordn_med_servfee;
    float ordn_trt_oprt_fee;
    float nurs_fee;
    float com_med_serv_oth_fee;
    float palg_diag_fee;
    float lab_diag_fee;
    float rdhy_diag_fee;
    float clnc_dise_fee;
    float nsrgtrt_item_fee;
    float clnc_phys_trt_fee;
    float rgtrt_trt_fee;
    float anst_fee;
    float oprn_fee;
    float rhab_fee;
    float tcm_trt_fee;
    float wmfee;
    float abtl_medn_fee;
    float tcmpat_fee;
    float tcmherb_fee;
    float blo_fee;
    float albu_fee;
    float glon_fee;
    float clotfac_fee;
    float cyki_fee;
    float exam_dspo_matl_fee;
    float trt_dspo_matl_fee;
    float oprn_dspo_matl_fee;
    float oth_fee;
    String vali_flag;
    String fixmedins_code;
    String trade_serial_cds;
    String upload_time_cds;
    int upload_state_cds;
    String grab_time;
    String inpatient_no;
    String type_flag;
    String upload_time_scs;
    int upload_state_scs;
    String trade_serial_scs;
    String medical_type;
    String pact_code;
    String insuplc_admdvs;
    String setl_date;
    String upload_time;
    String trade_serial;
    String upload_state;

    public String getType_flag() {
        return type_flag;
    }

    public String getMdtrt_sn() {
        return mdtrt_sn;
    }

    public String getMdtrt_id() {
        return mdtrt_id;
    }

    public String getInsuplc_admdvs() {
        return insuplc_admdvs;
    }

    public String getInpatient_no() {
        return inpatient_no;
    }

    public String getTrade_serial_cds() {
        return trade_serial_cds;
    }

    public String getUpload_time_cds() {
        return upload_time_cds;
    }

    public int getUpload_state_cds() {
        return upload_state_cds;
    }

    public String getUpload_time_scs() {
        return upload_time_scs;
    }

    public int getUpload_state_scs() {
        return upload_state_scs;
    }

    public String getTrade_serial_scs() {
        return trade_serial_scs;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public void setTrade_serial(String trade_serial) {
        this.trade_serial = trade_serial;
    }

    public void setUpload_state(String upload_state) {
        this.upload_state = upload_state;
    }

    public BaseInfoBean(String inpatient_no, String type_flag, String insuplc_admdvs) {
        this.inpatient_no = inpatient_no;
        this.type_flag = type_flag;
        this.insuplc_admdvs = insuplc_admdvs;
    }

    public BaseInfoBean(String mdtrt_sn, String mdtrt_id, String psn_no, String patn_ipt_cnt, String ipt_no, String medcasno, String psn_name, String gend, String brdy, String ntly, String ntly_name, float nwb_bir_wt, float nwb_adm_wt, String birplc, String napl, String naty_name, String naty, String certno, String prfs, String mrg_stas, String curr_addr_poscode, String curr_addr, String psn_tel, String resd_addr_prov, String resd_addr_city, String resd_addr_coty, String resd_addr_subd, String resd_addr_vil, String resd_addr_housnum, String resd_addr_poscode, String resd_addr, String empr_tel, String empr_poscode, String empr_addr, String coner_tel, String coner_name, String coner_addr, String coner_rlts_code, String adm_way_name, String adm_way_code, String trt_type_name, String trt_type, String adm_caty, String adm_ward, String adm_date, String dscg_date, String dscg_caty, String refldeptcatyname, String dscg_ward, int ipt_days, String drug_dicm_flag, String dicm_drug_name, String die_autp_flag, String abo_code, String abo_name, String rh_code, String rh_name, String die_flag, String deptdrt_name, String chfdr_name, String atddr_name, String chfpdr_name, String ipt_dr_name, String resp_nurs_name, String train_dr_name, String intn_dr_name, String codr_name, String qltctrl_dr_name, String qltctrl_nurs_name, String medcas_qlt_name, String medcas_qlt_code, String qltctrl_date, String dscg_way_name, String dscg_way, String acp_medins_code, String acp_medins_name, String dscg_31days_rinp_flag, String dscg_31days_rinp_pup, String damg_intx_ext_rea, String damg_intx_ext_rea_disecode, String brn_damg_bfadm_coma_dura, String brn_damg_afadm_coma_dura, String vent_used_dura, String cnfm_date, String patn_dise_diag_crsp, String patn_dise_diag_crsp_code, String ipt_patn_diag_inscp, String ipt_patn_diag_inscp_code, String dscg_trt_rslt, String dscg_trt_rslt_code, String medins_orgcode, float age, String aise, String pote_intn_dr_name, String hbsag, String hcvab, String hivab, int resc_cnt, int resc_succ_cnt, String hosp_dise_fsttime, String hif_pay_way_name, String hif_pay_way_code, String med_fee_paymtd_name, String medfee_paymtd_code, float selfpay_amt, float medfee_sumamt, float ordn_med_servfee, float ordn_trt_oprt_fee, float nurs_fee, float com_med_serv_oth_fee, float palg_diag_fee, float lab_diag_fee, float rdhy_diag_fee, float clnc_dise_fee, float nsrgtrt_item_fee, float clnc_phys_trt_fee, float rgtrt_trt_fee, float anst_fee, float oprn_fee, float rhab_fee, float tcm_trt_fee, float wmfee, float abtl_medn_fee, float tcmpat_fee, float tcmherb_fee, float blo_fee, float albu_fee, float glon_fee, float clotfac_fee, float cyki_fee, float exam_dspo_matl_fee, float trt_dspo_matl_fee, float oprn_dspo_matl_fee, float oth_fee, String vali_flag, String fixmedins_code, String trade_serial_cds, String upload_time_cds, int upload_state_cds, String grab_time, String inpatient_no, String type_flag, String upload_time_scs, int upload_state_scs, String trade_serial_scs, String medical_type, String pact_code, String insuplc_admdvs, String setl_date) {
        this.mdtrt_sn = mdtrt_sn;
        this.mdtrt_id = mdtrt_id;
        this.psn_no = psn_no;
        this.patn_ipt_cnt = patn_ipt_cnt;
        this.ipt_no = ipt_no;
        this.medcasno = medcasno;
        this.psn_name = psn_name;
        this.gend = gend;
        this.brdy = brdy;
        this.ntly = ntly;
        this.ntly_name = ntly_name;
        this.nwb_bir_wt = nwb_bir_wt;
        this.nwb_adm_wt = nwb_adm_wt;
        this.birplc = birplc;
        this.napl = napl;
        this.naty_name = naty_name;
        this.naty = naty;
        this.certno = certno;
        this.prfs = prfs;
        this.mrg_stas = mrg_stas;
        this.curr_addr_poscode = curr_addr_poscode;
        this.curr_addr = curr_addr;
        this.psn_tel = psn_tel;
        this.resd_addr_prov = resd_addr_prov;
        this.resd_addr_city = resd_addr_city;
        this.resd_addr_coty = resd_addr_coty;
        this.resd_addr_subd = resd_addr_subd;
        this.resd_addr_vil = resd_addr_vil;
        this.resd_addr_housnum = resd_addr_housnum;
        this.resd_addr_poscode = resd_addr_poscode;
        this.resd_addr = resd_addr;
        this.empr_tel = empr_tel;
        this.empr_poscode = empr_poscode;
        this.empr_addr = empr_addr;
        this.coner_tel = coner_tel;
        this.coner_name = coner_name;
        this.coner_addr = coner_addr;
        this.coner_rlts_code = coner_rlts_code;
        this.adm_way_name = adm_way_name;
        this.adm_way_code = adm_way_code;
        this.trt_type_name = trt_type_name;
        this.trt_type = trt_type;
        this.adm_caty = adm_caty;
        this.adm_ward = adm_ward;
        this.adm_date = adm_date;
        this.dscg_date = dscg_date;
        this.dscg_caty = dscg_caty;
        this.refldeptcatyname = refldeptcatyname;
        this.dscg_ward = dscg_ward;
        this.ipt_days = ipt_days;
        this.drug_dicm_flag = drug_dicm_flag;
        this.dicm_drug_name = dicm_drug_name;
        this.die_autp_flag = die_autp_flag;
        this.abo_code = abo_code;
        this.abo_name = abo_name;
        this.rh_code = rh_code;
        this.rh_name = rh_name;
        this.die_flag = die_flag;
        this.deptdrt_name = deptdrt_name;
        this.chfdr_name = chfdr_name;
        this.atddr_name = atddr_name;
        this.chfpdr_name = chfpdr_name;
        this.ipt_dr_name = ipt_dr_name;
        this.resp_nurs_name = resp_nurs_name;
        this.train_dr_name = train_dr_name;
        this.intn_dr_name = intn_dr_name;
        this.codr_name = codr_name;
        this.qltctrl_dr_name = qltctrl_dr_name;
        this.qltctrl_nurs_name = qltctrl_nurs_name;
        this.medcas_qlt_name = medcas_qlt_name;
        this.medcas_qlt_code = medcas_qlt_code;
        this.qltctrl_date = qltctrl_date;
        this.dscg_way_name = dscg_way_name;
        this.dscg_way = dscg_way;
        this.acp_medins_code = acp_medins_code;
        this.acp_medins_name = acp_medins_name;
        this.dscg_31days_rinp_flag = dscg_31days_rinp_flag;
        this.dscg_31days_rinp_pup = dscg_31days_rinp_pup;
        this.damg_intx_ext_rea = damg_intx_ext_rea;
        this.damg_intx_ext_rea_disecode = damg_intx_ext_rea_disecode;
        this.brn_damg_bfadm_coma_dura = brn_damg_bfadm_coma_dura;
        this.brn_damg_afadm_coma_dura = brn_damg_afadm_coma_dura;
        this.vent_used_dura = vent_used_dura;
        this.cnfm_date = cnfm_date;
        this.patn_dise_diag_crsp = patn_dise_diag_crsp;
        this.patn_dise_diag_crsp_code = patn_dise_diag_crsp_code;
        this.ipt_patn_diag_inscp = ipt_patn_diag_inscp;
        this.ipt_patn_diag_inscp_code = ipt_patn_diag_inscp_code;
        this.dscg_trt_rslt = dscg_trt_rslt;
        this.dscg_trt_rslt_code = dscg_trt_rslt_code;
        this.medins_orgcode = medins_orgcode;
        this.age = age;
        this.aise = aise;
        this.pote_intn_dr_name = pote_intn_dr_name;
        this.hbsag = hbsag;
        this.hcvab = hcvab;
        this.hivab = hivab;
        this.resc_cnt = resc_cnt;
        this.resc_succ_cnt = resc_succ_cnt;
        this.hosp_dise_fsttime = hosp_dise_fsttime;
        this.hif_pay_way_name = hif_pay_way_name;
        this.hif_pay_way_code = hif_pay_way_code;
        this.med_fee_paymtd_name = med_fee_paymtd_name;
        this.medfee_paymtd_code = medfee_paymtd_code;
        this.selfpay_amt = selfpay_amt;
        this.medfee_sumamt = medfee_sumamt;
        this.ordn_med_servfee = ordn_med_servfee;
        this.ordn_trt_oprt_fee = ordn_trt_oprt_fee;
        this.nurs_fee = nurs_fee;
        this.com_med_serv_oth_fee = com_med_serv_oth_fee;
        this.palg_diag_fee = palg_diag_fee;
        this.lab_diag_fee = lab_diag_fee;
        this.rdhy_diag_fee = rdhy_diag_fee;
        this.clnc_dise_fee = clnc_dise_fee;
        this.nsrgtrt_item_fee = nsrgtrt_item_fee;
        this.clnc_phys_trt_fee = clnc_phys_trt_fee;
        this.rgtrt_trt_fee = rgtrt_trt_fee;
        this.anst_fee = anst_fee;
        this.oprn_fee = oprn_fee;
        this.rhab_fee = rhab_fee;
        this.tcm_trt_fee = tcm_trt_fee;
        this.wmfee = wmfee;
        this.abtl_medn_fee = abtl_medn_fee;
        this.tcmpat_fee = tcmpat_fee;
        this.tcmherb_fee = tcmherb_fee;
        this.blo_fee = blo_fee;
        this.albu_fee = albu_fee;
        this.glon_fee = glon_fee;
        this.clotfac_fee = clotfac_fee;
        this.cyki_fee = cyki_fee;
        this.exam_dspo_matl_fee = exam_dspo_matl_fee;
        this.trt_dspo_matl_fee = trt_dspo_matl_fee;
        this.oprn_dspo_matl_fee = oprn_dspo_matl_fee;
        this.oth_fee = oth_fee;
        this.vali_flag = vali_flag;
        this.fixmedins_code = fixmedins_code;
        this.trade_serial_cds = trade_serial_cds;
        this.upload_time_cds = upload_time_cds;
        this.upload_state_cds = upload_state_cds;
        this.grab_time = grab_time;
        this.inpatient_no = inpatient_no;
        this.type_flag = type_flag;
        this.upload_time_scs = upload_time_scs;
        this.upload_state_scs = upload_state_scs;
        this.trade_serial_scs = trade_serial_scs;
        this.medical_type = medical_type;
        this.pact_code = pact_code;
        this.insuplc_admdvs = insuplc_admdvs;
        this.setl_date = setl_date;
    }

    public BaseInfoBean(String mdtrt_sn, String mdtrt_id, String psn_no, String patn_ipt_cnt, String ipt_no, String medcasno, String psn_name, String gend, String brdy, String ntly, String ntly_name, float nwb_bir_wt, float nwb_adm_wt, String birplc, String napl, String naty_name, String naty, String certno, String prfs, String mrg_stas, String curr_addr_poscode, String curr_addr, String psn_tel, String resd_addr_prov, String resd_addr_city, String resd_addr_coty, String resd_addr_subd, String resd_addr_vil, String resd_addr_housnum, String resd_addr_poscode, String resd_addr, String empr_tel, String empr_poscode, String empr_addr, String coner_tel, String coner_name, String coner_addr, String coner_rlts_code, String adm_way_name, String adm_way_code, String trt_type_name, String trt_type, String adm_caty, String adm_ward, String adm_date, String dscg_date, String dscg_caty, String refldeptcatyname, String dscg_ward, int ipt_days, String drug_dicm_flag, String dicm_drug_name, String die_autp_flag, String abo_code, String abo_name, String rh_code, String rh_name, String die_flag, String deptdrt_name, String chfdr_name, String atddr_name, String chfpdr_name, String ipt_dr_name, String resp_nurs_name, String train_dr_name, String intn_dr_name, String codr_name, String qltctrl_dr_name, String qltctrl_nurs_name, String medcas_qlt_name, String medcas_qlt_code, String qltctrl_date, String dscg_way_name, String dscg_way, String acp_medins_code, String acp_medins_name, String dscg_31days_rinp_flag, String dscg_31days_rinp_pup, String damg_intx_ext_rea, String damg_intx_ext_rea_disecode, String brn_damg_bfadm_coma_dura, String brn_damg_afadm_coma_dura, String vent_used_dura, String cnfm_date, String patn_dise_diag_crsp, String patn_dise_diag_crsp_code, String ipt_patn_diag_inscp, String ipt_patn_diag_inscp_code, String dscg_trt_rslt, String dscg_trt_rslt_code, String medins_orgcode, float age, String aise, String pote_intn_dr_name, String hbsag, String hcvab, String hivab, int resc_cnt, int resc_succ_cnt, String hosp_dise_fsttime, String hif_pay_way_name, String hif_pay_way_code, String med_fee_paymtd_name, String medfee_paymtd_code, float selfpay_amt, float medfee_sumamt, float ordn_med_servfee, float ordn_trt_oprt_fee, float nurs_fee, float com_med_serv_oth_fee, float palg_diag_fee, float lab_diag_fee, float rdhy_diag_fee, float clnc_dise_fee, float nsrgtrt_item_fee, float clnc_phys_trt_fee, float rgtrt_trt_fee, float anst_fee, float oprn_fee, float rhab_fee, float tcm_trt_fee, float wmfee, float abtl_medn_fee, float tcmpat_fee, float tcmherb_fee, float blo_fee, float albu_fee, float glon_fee, float clotfac_fee, float cyki_fee, float exam_dspo_matl_fee, float trt_dspo_matl_fee, float oprn_dspo_matl_fee, float oth_fee, String vali_flag, String fixmedins_code) {
        this.mdtrt_sn = mdtrt_sn;
        this.mdtrt_id = mdtrt_id;
        this.psn_no = psn_no;
        this.patn_ipt_cnt = patn_ipt_cnt;
        this.ipt_no = ipt_no;
        this.medcasno = medcasno;
        this.psn_name = psn_name;
        this.gend = gend;
        this.brdy = brdy;
        this.ntly = ntly;
        this.ntly_name = ntly_name;
        this.nwb_bir_wt = nwb_bir_wt;
        this.nwb_adm_wt = nwb_adm_wt;
        this.birplc = birplc;
        this.napl = napl;
        this.naty_name = naty_name;
        this.naty = naty;
        this.certno = certno;
        this.prfs = prfs;
        this.mrg_stas = mrg_stas;
        this.curr_addr_poscode = curr_addr_poscode;
        this.curr_addr = curr_addr;
        this.psn_tel = psn_tel;
        this.resd_addr_prov = resd_addr_prov;
        this.resd_addr_city = resd_addr_city;
        this.resd_addr_coty = resd_addr_coty;
        this.resd_addr_subd = resd_addr_subd;
        this.resd_addr_vil = resd_addr_vil;
        this.resd_addr_housnum = resd_addr_housnum;
        this.resd_addr_poscode = resd_addr_poscode;
        this.resd_addr = resd_addr;
        this.empr_tel = empr_tel;
        this.empr_poscode = empr_poscode;
        this.empr_addr = empr_addr;
        this.coner_tel = coner_tel;
        this.coner_name = coner_name;
        this.coner_addr = coner_addr;
        this.coner_rlts_code = coner_rlts_code;
        this.adm_way_name = adm_way_name;
        this.adm_way_code = adm_way_code;
        this.trt_type_name = trt_type_name;
        this.trt_type = trt_type;
        this.adm_caty = adm_caty;
        this.adm_ward = adm_ward;
        this.adm_date = adm_date;
        this.dscg_date = dscg_date;
        this.dscg_caty = dscg_caty;
        this.refldeptcatyname = refldeptcatyname;
        this.dscg_ward = dscg_ward;
        this.ipt_days = ipt_days;
        this.drug_dicm_flag = drug_dicm_flag;
        this.dicm_drug_name = dicm_drug_name;
        this.die_autp_flag = die_autp_flag;
        this.abo_code = abo_code;
        this.abo_name = abo_name;
        this.rh_code = rh_code;
        this.rh_name = rh_name;
        this.die_flag = die_flag;
        this.deptdrt_name = deptdrt_name;
        this.chfdr_name = chfdr_name;
        this.atddr_name = atddr_name;
        this.chfpdr_name = chfpdr_name;
        this.ipt_dr_name = ipt_dr_name;
        this.resp_nurs_name = resp_nurs_name;
        this.train_dr_name = train_dr_name;
        this.intn_dr_name = intn_dr_name;
        this.codr_name = codr_name;
        this.qltctrl_dr_name = qltctrl_dr_name;
        this.qltctrl_nurs_name = qltctrl_nurs_name;
        this.medcas_qlt_name = medcas_qlt_name;
        this.medcas_qlt_code = medcas_qlt_code;
        this.qltctrl_date = qltctrl_date;
        this.dscg_way_name = dscg_way_name;
        this.dscg_way = dscg_way;
        this.acp_medins_code = acp_medins_code;
        this.acp_medins_name = acp_medins_name;
        this.dscg_31days_rinp_flag = dscg_31days_rinp_flag;
        this.dscg_31days_rinp_pup = dscg_31days_rinp_pup;
        this.damg_intx_ext_rea = damg_intx_ext_rea;
        this.damg_intx_ext_rea_disecode = damg_intx_ext_rea_disecode;
        this.brn_damg_bfadm_coma_dura = brn_damg_bfadm_coma_dura;
        this.brn_damg_afadm_coma_dura = brn_damg_afadm_coma_dura;
        this.vent_used_dura = vent_used_dura;
        this.cnfm_date = cnfm_date;
        this.patn_dise_diag_crsp = patn_dise_diag_crsp;
        this.patn_dise_diag_crsp_code = patn_dise_diag_crsp_code;
        this.ipt_patn_diag_inscp = ipt_patn_diag_inscp;
        this.ipt_patn_diag_inscp_code = ipt_patn_diag_inscp_code;
        this.dscg_trt_rslt = dscg_trt_rslt;
        this.dscg_trt_rslt_code = dscg_trt_rslt_code;
        this.medins_orgcode = medins_orgcode;
        this.age = age;
        this.aise = aise;
        this.pote_intn_dr_name = pote_intn_dr_name;
        this.hbsag = hbsag;
        this.hcvab = hcvab;
        this.hivab = hivab;
        this.resc_cnt = resc_cnt;
        this.resc_succ_cnt = resc_succ_cnt;
        this.hosp_dise_fsttime = hosp_dise_fsttime;
        this.hif_pay_way_name = hif_pay_way_name;
        this.hif_pay_way_code = hif_pay_way_code;
        this.med_fee_paymtd_name = med_fee_paymtd_name;
        this.medfee_paymtd_code = medfee_paymtd_code;
        this.selfpay_amt = selfpay_amt;
        this.medfee_sumamt = medfee_sumamt;
        this.ordn_med_servfee = ordn_med_servfee;
        this.ordn_trt_oprt_fee = ordn_trt_oprt_fee;
        this.nurs_fee = nurs_fee;
        this.com_med_serv_oth_fee = com_med_serv_oth_fee;
        this.palg_diag_fee = palg_diag_fee;
        this.lab_diag_fee = lab_diag_fee;
        this.rdhy_diag_fee = rdhy_diag_fee;
        this.clnc_dise_fee = clnc_dise_fee;
        this.nsrgtrt_item_fee = nsrgtrt_item_fee;
        this.clnc_phys_trt_fee = clnc_phys_trt_fee;
        this.rgtrt_trt_fee = rgtrt_trt_fee;
        this.anst_fee = anst_fee;
        this.oprn_fee = oprn_fee;
        this.rhab_fee = rhab_fee;
        this.tcm_trt_fee = tcm_trt_fee;
        this.wmfee = wmfee;
        this.abtl_medn_fee = abtl_medn_fee;
        this.tcmpat_fee = tcmpat_fee;
        this.tcmherb_fee = tcmherb_fee;
        this.blo_fee = blo_fee;
        this.albu_fee = albu_fee;
        this.glon_fee = glon_fee;
        this.clotfac_fee = clotfac_fee;
        this.cyki_fee = cyki_fee;
        this.exam_dspo_matl_fee = exam_dspo_matl_fee;
        this.trt_dspo_matl_fee = trt_dspo_matl_fee;
        this.oprn_dspo_matl_fee = oprn_dspo_matl_fee;
        this.oth_fee = oth_fee;
        this.vali_flag = vali_flag;
        this.fixmedins_code = fixmedins_code;
    }

    public BaseInfoBean(String mdtrt_sn, String mdtrt_id, String psn_no, String psn_name, String adm_date, String dscg_date, String trade_serial_cds, String upload_time_cds, int upload_state_cds, String grab_time, String type_flag, String upload_time_scs, int upload_state_scs, String trade_serial_scs, String setl_date,String insuplc_admdvs) throws ParseException {
        this.mdtrt_sn = mdtrt_sn;
        this.mdtrt_id = mdtrt_id;
        this.psn_no = psn_no;
        this.psn_name = psn_name;
        if (adm_date != null && !adm_date.equals("")) {
            this.adm_date = Utils.SqlTimeToDate(adm_date);
        }
        if (dscg_date != null && !dscg_date.equals("")) {
            this.dscg_date = Utils.SqlTimeToDate(dscg_date);
        }
        this.trade_serial_cds = trade_serial_cds;
        if (upload_time_cds != null && !upload_time_cds.equals("")) {
            this.upload_time_cds = Utils.SqlTimeToTime(upload_time_cds);
        }
        this.upload_state_cds = upload_state_cds;
        if (grab_time != null && !grab_time.equals("")) {
            this.grab_time = Utils.SqlTimeToTime(grab_time);
        }
        this.type_flag = type_flag;
        if (upload_time_scs != null && !upload_time_scs.equals("")) {
            this.upload_time_scs = Utils.SqlTimeToTime(upload_time_scs);
        }
        this.upload_state_scs = upload_state_scs;
        this.trade_serial_scs = trade_serial_scs;
        if (setl_date != null && !setl_date.equals("")) {
            this.setl_date = Utils.SqlTimeToDate(setl_date);
        }
        this.insuplc_admdvs =insuplc_admdvs;
    }

    @Override
    public String toString() {
        return "BaseInfoBean{" +
                "mdtrt_sn='" + mdtrt_sn + '\'' +
                ", mdtrt_id='" + mdtrt_id + '\'' +
                ", psn_no='" + psn_no + '\'' +
                ", patn_ipt_cnt='" + patn_ipt_cnt + '\'' +
                ", ipt_no='" + ipt_no + '\'' +
                ", medcasno='" + medcasno + '\'' +
                ", psn_name='" + psn_name + '\'' +
                ", gend='" + gend + '\'' +
                ", brdy='" + brdy + '\'' +
                ", ntly='" + ntly + '\'' +
                ", ntly_name='" + ntly_name + '\'' +
                ", nwb_bir_wt=" + nwb_bir_wt +
                ", nwb_adm_wt=" + nwb_adm_wt +
                ", birplc='" + birplc + '\'' +
                ", napl='" + napl + '\'' +
                ", naty_name='" + naty_name + '\'' +
                ", naty='" + naty + '\'' +
                ", certno='" + certno + '\'' +
                ", prfs='" + prfs + '\'' +
                ", mrg_stas='" + mrg_stas + '\'' +
                ", curr_addr_poscode='" + curr_addr_poscode + '\'' +
                ", curr_addr='" + curr_addr + '\'' +
                ", psn_tel='" + psn_tel + '\'' +
                ", resd_addr_prov='" + resd_addr_prov + '\'' +
                ", resd_addr_city='" + resd_addr_city + '\'' +
                ", resd_addr_coty='" + resd_addr_coty + '\'' +
                ", resd_addr_subd='" + resd_addr_subd + '\'' +
                ", resd_addr_vil='" + resd_addr_vil + '\'' +
                ", resd_addr_housnum='" + resd_addr_housnum + '\'' +
                ", resd_addr_poscode='" + resd_addr_poscode + '\'' +
                ", resd_addr='" + resd_addr + '\'' +
                ", empr_tel='" + empr_tel + '\'' +
                ", empr_poscode='" + empr_poscode + '\'' +
                ", empr_addr='" + empr_addr + '\'' +
                ", coner_tel='" + coner_tel + '\'' +
                ", coner_name='" + coner_name + '\'' +
                ", coner_addr='" + coner_addr + '\'' +
                ", coner_rlts_code='" + coner_rlts_code + '\'' +
                ", adm_way_name='" + adm_way_name + '\'' +
                ", adm_way_code='" + adm_way_code + '\'' +
                ", trt_type_name='" + trt_type_name + '\'' +
                ", trt_type='" + trt_type + '\'' +
                ", adm_caty='" + adm_caty + '\'' +
                ", adm_ward='" + adm_ward + '\'' +
                ", adm_date='" + adm_date + '\'' +
                ", dscg_date='" + dscg_date + '\'' +
                ", dscg_caty='" + dscg_caty + '\'' +
                ", refldeptcatyname='" + refldeptcatyname + '\'' +
                ", dscg_ward='" + dscg_ward + '\'' +
                ", ipt_days=" + ipt_days +
                ", drug_dicm_flag='" + drug_dicm_flag + '\'' +
                ", dicm_drug_name='" + dicm_drug_name + '\'' +
                ", die_autp_flag='" + die_autp_flag + '\'' +
                ", abo_code='" + abo_code + '\'' +
                ", abo_name='" + abo_name + '\'' +
                ", rh_code='" + rh_code + '\'' +
                ", rh_name='" + rh_name + '\'' +
                ", die_flag='" + die_flag + '\'' +
                ", deptdrt_name='" + deptdrt_name + '\'' +
                ", chfdr_name='" + chfdr_name + '\'' +
                ", atddr_name='" + atddr_name + '\'' +
                ", chfpdr_name='" + chfpdr_name + '\'' +
                ", ipt_dr_name='" + ipt_dr_name + '\'' +
                ", resp_nurs_name='" + resp_nurs_name + '\'' +
                ", train_dr_name='" + train_dr_name + '\'' +
                ", intn_dr_name='" + intn_dr_name + '\'' +
                ", codr_name='" + codr_name + '\'' +
                ", qltctrl_dr_name='" + qltctrl_dr_name + '\'' +
                ", qltctrl_nurs_name='" + qltctrl_nurs_name + '\'' +
                ", medcas_qlt_name='" + medcas_qlt_name + '\'' +
                ", medcas_qlt_code='" + medcas_qlt_code + '\'' +
                ", qltctrl_date='" + qltctrl_date + '\'' +
                ", dscg_way_name='" + dscg_way_name + '\'' +
                ", dscg_way='" + dscg_way + '\'' +
                ", acp_medins_code='" + acp_medins_code + '\'' +
                ", acp_medins_name='" + acp_medins_name + '\'' +
                ", dscg_31days_rinp_flag='" + dscg_31days_rinp_flag + '\'' +
                ", dscg_31days_rinp_pup='" + dscg_31days_rinp_pup + '\'' +
                ", damg_intx_ext_rea='" + damg_intx_ext_rea + '\'' +
                ", damg_intx_ext_rea_disecode='" + damg_intx_ext_rea_disecode + '\'' +
                ", brn_damg_bfadm_coma_dura='" + brn_damg_bfadm_coma_dura + '\'' +
                ", brn_damg_afadm_coma_dura='" + brn_damg_afadm_coma_dura + '\'' +
                ", vent_used_dura='" + vent_used_dura + '\'' +
                ", cnfm_date='" + cnfm_date + '\'' +
                ", patn_dise_diag_crsp='" + patn_dise_diag_crsp + '\'' +
                ", patn_dise_diag_crsp_code='" + patn_dise_diag_crsp_code + '\'' +
                ", ipt_patn_diag_inscp='" + ipt_patn_diag_inscp + '\'' +
                ", ipt_patn_diag_inscp_code='" + ipt_patn_diag_inscp_code + '\'' +
                ", dscg_trt_rslt='" + dscg_trt_rslt + '\'' +
                ", dscg_trt_rslt_code='" + dscg_trt_rslt_code + '\'' +
                ", medins_orgcode='" + medins_orgcode + '\'' +
                ", age=" + age +
                ", aise='" + aise + '\'' +
                ", pote_intn_dr_name='" + pote_intn_dr_name + '\'' +
                ", hbsag='" + hbsag + '\'' +
                ", hcvab='" + hcvab + '\'' +
                ", hivab='" + hivab + '\'' +
                ", resc_cnt=" + resc_cnt +
                ", resc_succ_cnt=" + resc_succ_cnt +
                ", hosp_dise_fsttime='" + hosp_dise_fsttime + '\'' +
                ", hif_pay_way_name='" + hif_pay_way_name + '\'' +
                ", hif_pay_way_code='" + hif_pay_way_code + '\'' +
                ", med_fee_paymtd_name='" + med_fee_paymtd_name + '\'' +
                ", medfee_paymtd_code='" + medfee_paymtd_code + '\'' +
                ", selfpay_amt=" + selfpay_amt +
                ", medfee_sumamt=" + medfee_sumamt +
                ", ordn_med_servfee=" + ordn_med_servfee +
                ", ordn_trt_oprt_fee=" + ordn_trt_oprt_fee +
                ", nurs_fee=" + nurs_fee +
                ", com_med_serv_oth_fee=" + com_med_serv_oth_fee +
                ", palg_diag_fee=" + palg_diag_fee +
                ", lab_diag_fee=" + lab_diag_fee +
                ", rdhy_diag_fee=" + rdhy_diag_fee +
                ", clnc_dise_fee=" + clnc_dise_fee +
                ", nsrgtrt_item_fee=" + nsrgtrt_item_fee +
                ", clnc_phys_trt_fee=" + clnc_phys_trt_fee +
                ", rgtrt_trt_fee=" + rgtrt_trt_fee +
                ", anst_fee=" + anst_fee +
                ", oprn_fee=" + oprn_fee +
                ", rhab_fee=" + rhab_fee +
                ", tcm_trt_fee=" + tcm_trt_fee +
                ", wmfee=" + wmfee +
                ", abtl_medn_fee=" + abtl_medn_fee +
                ", tcmpat_fee=" + tcmpat_fee +
                ", tcmherb_fee=" + tcmherb_fee +
                ", blo_fee=" + blo_fee +
                ", albu_fee=" + albu_fee +
                ", glon_fee=" + glon_fee +
                ", clotfac_fee=" + clotfac_fee +
                ", cyki_fee=" + cyki_fee +
                ", exam_dspo_matl_fee=" + exam_dspo_matl_fee +
                ", trt_dspo_matl_fee=" + trt_dspo_matl_fee +
                ", oprn_dspo_matl_fee=" + oprn_dspo_matl_fee +
                ", oth_fee=" + oth_fee +
                ", vali_flag='" + vali_flag + '\'' +
                ", fixmedins_code='" + fixmedins_code + '\'' +
                ", trade_serial_cds='" + trade_serial_cds + '\'' +
                ", upload_time_cds='" + upload_time_cds + '\'' +
                ", upload_state_cds=" + upload_state_cds +
                ", grab_time='" + grab_time + '\'' +
                ", inpatient_no='" + inpatient_no + '\'' +
                ", type_flag='" + type_flag + '\'' +
                ", upload_time_scs='" + upload_time_scs + '\'' +
                ", upload_state_scs=" + upload_state_scs +
                ", trade_serial_scs='" + trade_serial_scs + '\'' +
                ", medical_type='" + medical_type + '\'' +
                ", pact_code='" + pact_code + '\'' +
                ", insuplc_admdvs='" + insuplc_admdvs + '\'' +
                ", setl_date='" + setl_date + '\'' +
                ", upload_time='" + upload_time + '\'' +
                ", trade_serial='" + trade_serial + '\'' +
                ", upload_state='" + upload_state + '\'' +
                '}';
    }
}
