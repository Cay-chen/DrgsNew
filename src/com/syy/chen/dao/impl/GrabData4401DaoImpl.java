package com.syy.chen.dao.impl;

import com.syy.chen.Utils;
import com.syy.chen.dao.GrabData4401Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GrabData4401DaoImpl implements GrabData4401Dao {
    @Override
    public int getData(String date, Connection con, Connection baglConn) throws Exception {
        int num = -1;
        String sql = "select * from V_4101A_HIS sc where sc.type_code='2' and sc.setl_time >= '" + date + " 00:00:00' and sc.setl_time <= '" + date + " 23:59:59'";
        //String sql = "select * from V_4101A_HIS sc where sc.type_code='2' and sc.setl_time >= '2022-06-09 00:00:00' and sc.setl_time <= '2022-06-09 23:59:59' and  sc.setl_id='510100CD000084328080'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            // String setlIdMain = rs.getObject(3).toString() + "-" + rs.getObject(8).toString();
            num = getBaglBaseInfo(con, baglConn, rs.getString(1), rs.getString(2), rs.getString(6),
                    rs.getString(5), rs.getString(10), Utils.YbFenLei(rs.getString(5)), rs.getString(9), rs.getString(7));

        }
        rs.close();
        ps.close();
        return num;
    }

    private int getBaglBaseInfo(Connection conn, Connection baglConn, String psnNo, String mdId, String pactCode, String insuplcAdmdvs, String setlDate, String typeFlag, String inpatientNo, String medicalType) throws Exception {
        String sql = "select * from V_YB_SETLINFO_4401 v where v.mdtrt_sn='" + inpatientNo + "'";
        PreparedStatement baPs = null;
        ResultSet baRs = null;
        PreparedStatement ps = null;
        StringBuffer insertSql = null;
        int num = 0;
        try {
            baPs = baglConn.prepareStatement(sql);
            baRs = baPs.executeQuery();
            while (baRs.next()) {
                insertSql = new StringBuffer();
                String fix = "H51010501809";
                insertSql.append("INSERT INTO DATA_4401_BASEINFO (mdtrt_sn,mdtrt_id,psn_no,patn_ipt_cnt,ipt_no,medcasno,psn_name,gend,brdy,ntly,ntly_name,nwb_bir_wt,nwb_adm_wt,birplc,napl,naty_name,naty,certno,prfs,mrg_stas,curr_addr_poscode,curr_addr,psn_tel,resd_addr_prov,resd_addr_city,resd_addr_coty,resd_addr_subd,resd_addr_vil,resd_addr_housnum,resd_addr_poscode,resd_addr,empr_tel,empr_poscode,empr_addr,coner_tel,coner_name,coner_addr,coner_rlts_code,adm_way_name,adm_way_code,trt_type_name,trt_type,adm_caty,adm_ward,adm_date,dscg_date,dscg_caty,refldeptcatyname,dscg_ward,ipt_days,drug_dicm_flag,dicm_drug_name,die_autp_flag,abo_code,abo_name,rh_code,rh_name,die_flag,deptdrt_name,chfdr_name,atddr_name,chfpdr_name,ipt_dr_name,resp_nurs_name,train_dr_name,intn_dr_name,codr_name,qltctrl_dr_name,qltctrl_nurs_name,medcas_qlt_name,medcas_qlt_code,qltctrl_date,dscg_way_name,dscg_way,acp_medins_code,acp_medins_name,dscg_31days_rinp_flag,dscg_31days_rinp_pup,damg_intx_ext_rea,damg_intx_ext_rea_disecode,brn_damg_bfadm_coma_dura,brn_damg_afadm_coma_dura,vent_used_dura,cnfm_date,patn_dise_diag_crsp,patn_dise_diag_crsp_code,ipt_patn_diag_inscp,ipt_patn_diag_inscp_code,dscg_trt_rslt,dscg_trt_rslt_code,medins_orgcode,age,aise,pote_intn_dr_name,hbsag,hcvab,hivab,resc_cnt,resc_succ_cnt,hosp_dise_fsttime,hif_pay_way_name,hif_pay_way_code,med_fee_paymtd_name,medfee_paymtd_code,selfpay_amt,medfee_sumamt,ordn_med_servfee,ordn_trt_oprt_fee,nurs_fee,com_med_serv_oth_fee,palg_diag_fee,lab_diag_fee,rdhy_diag_fee,clnc_dise_fee,nsrgtrt_item_fee,clnc_phys_trt_fee,rgtrt_trt_fee,anst_fee,oprn_fee,rhab_fee,tcm_trt_fee,wmfee,abtl_medn_fee,tcmpat_fee,tcmherb_fee,blo_fee,albu_fee,glon_fee,clotfac_fee,cyki_fee,exam_dspo_matl_fee,trt_dspo_matl_fee,oprn_dspo_matl_fee,oth_fee,vali_flag,fixmedins_code,grab_time,pact_code,insuplc_admdvs,setl_date,type_flag,inpatient_no,medical_type) VALUES (");
                // String sqlI = "INSERT INTO DATA_4401_BASEINFO (mdtrt_sn,mdtrt_id,psn_no,patn_ipt_cnt,ipt_no,medcasno,psn_name,gend,brdy,ntly,ntly_name,nwb_bir_wt,nwb_adm_wt,birplc,napl,naty_name,naty,certno,prfs,mrg_stas,curr_addr_poscode,curr_addr,psn_tel,resd_addr_prov,resd_addr_city,resd_addr_coty,resd_addr_subd,resd_addr_vil,resd_addr_housnum,resd_addr_poscode,resd_addr,empr_tel,empr_poscode,empr_addr,coner_tel,coner_name,coner_addr,coner_rlts_code,adm_way_name,adm_way_code,trt_type_name,trt_type,adm_caty,adm_ward,adm_date,dscg_date,dscg_caty,refldeptcatyname,dscg_ward,ipt_days,drug_dicm_flag,dicm_drug_name,die_autp_flag,abo_code,abo_name,rh_code,rh_name,die_flag,deptdrt_name,chfdr_name,atddr_name,chfpdr_name,ipt_dr_name,resp_nurs_name,train_dr_name,intn_dr_name,codr_name,qltctrl_dr_name,qltctrl_nurs_name,medcas_qlt_name,medcas_qlt_code,qltctrl_date,dscg_way_name,dscg_way,acp_medins_code,acp_medins_name,dscg_31days_rinp_flag,dscg_31days_rinp_pup,damg_intx_ext_rea,damg_intx_ext_rea_disecode,brn_damg_bfadm_coma_dura,brn_damg_afadm_coma_dura,vent_used_dura,cnfm_date,patn_dise_diag_crsp,patn_dise_diag_crsp_code,ipt_patn_diag_inscp,ipt_patn_diag_inscp_code,dscg_trt_rslt,dscg_trt_rslt_code,medins_orgcode,age,aise,pote_intn_dr_name,hbsag,hcvab,hivab,resc_cnt,resc_succ_cnt,hosp_dise_fsttime,hif_pay_way_name,hif_pay_way_code,med_fee_paymtd_name,medfee_paymtd_code,selfpay_amt,medfee_sumamt,ordn_med_servfee,ordn_trt_oprt_fee,nurs_fee,com_med_serv_oth_fee,palg_diag_fee,lab_diag_fee,rdhy_diag_fee,clnc_dise_fee,nsrgtrt_item_fee,clnc_phys_trt_fee,rgtrt_trt_fee,anst_fee,oprn_fee,rhab_fee,tcm_trt_fee,wmfee,abtl_medn_fee,tcmpat_fee,tcmherb_fee,blo_fee,albu_fee,glon_fee,clotfac_fee,cyki_fee,exam_dspo_matl_fee,trt_dspo_matl_fee,oprn_dspo_matl_fee,oth_fee,vali_flag,fixmedins_code,grab_time,pact_code,insuplc_admdvs,setl_date,type_flag,inpatient_no,medical_type) VALUES ( ?,?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),to_date(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd HH24:mi:ss'),?,?,?,?,?,?)";
                Utils.SqlStringAppend(insertSql, 99, fix + inpatientNo);
                Utils.SqlStringAppend(insertSql, 99, mdId);
                Utils.SqlStringAppend(insertSql, 99, psnNo);
               /* Utils.SqlStringAppend(insertSql, 1,baRs.getString(4));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(5));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(6));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(7));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(8));
                Utils.SqlDateAppend(insertSql, 1,Utils.SqlTimeToDate(baRs.getString(9)));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(11));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(12));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(13));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(14));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(15));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(16));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(17));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(18));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(19));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(20));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(21));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(22));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(23));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(24));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(25));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(26));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(27));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(28));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(29));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(30));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(31));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(32));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(33));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(34));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(35));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(36));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(37));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(38));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(39));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(40));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(41));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(42));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(43));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(44));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(45));
                Utils.SqlDateAppend(insertSql, 1,Utils.SqlTimeToDate(baRs.getString(46)));
                Utils.SqlDateAppend(insertSql, 1,Utils.SqlTimeToDate(baRs.getString(47)));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(48));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(49));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(50));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(51));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(52));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(53));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(54));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(55));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(56));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(57));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(58));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(59));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(60));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(61));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(62));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(63));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(64));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(65));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(66));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(67));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(68));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(69));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(70));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(71));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(72));
                Utils.SqlDateAppend(insertSql, 1,Utils.SqlTimeToDate(baRs.getString(73)));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(74));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(75));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(76));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(77));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(78));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(79));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(80));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(81));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(82));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(83));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(84));
                Utils.SqlDateAppend(insertSql, 1,Utils.SqlTimeToDate(baRs.getString(85)));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(86));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(87));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(88));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(89));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(90));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(91));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(92));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(10));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(93));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(94));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(95));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(96));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(97));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(98));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(99));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(100));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(101));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(102));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(103));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(104));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(105));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(106));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(107));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(108));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(109));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(110));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(111));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(112));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(113));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(114));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(115));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(116));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(117));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(118));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(119));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(120));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(121));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(122));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(123));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(124));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(125));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(126));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(127));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(128));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(129));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(130));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(131));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(132));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(133));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(134));
                Utils.SqlStringAppend(insertSql, 1,baRs.getString(135));*/


                Utils.SqlStringAppend(insertSql, 1, baRs.getString(4));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(5));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(6));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(7));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(8));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(baRs.getString(9)));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(11));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(12));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(13));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(14));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(15));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(16));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(17));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(18));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(19));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(20));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(21));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(22));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(23));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(24));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(25));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(26));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(27));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(28));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(29));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(30));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(31));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(32));
                Utils.SqlStringAppend(insertSql, 1, Utils.telYc(baRs.getString(33)));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(34));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(35));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(36));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(37));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(38));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(39));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(40));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(41));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(42));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(43));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(44));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(45));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(baRs.getString(46)));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(baRs.getString(47)));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(48));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(49));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(50));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(51));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(52));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(53));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(54));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(55));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(56));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(57));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(58));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(59));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(60));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(61));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(62));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(63));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(64));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(65));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(66));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(67));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(68));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(69));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(70));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(71));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(72));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(baRs.getString(73)));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(74));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(75));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(76));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(77));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(78));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(79));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(80));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(81));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(82));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(83));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(84));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(baRs.getString(85)));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(86));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(87));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(88));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(89));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(90));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(91));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(92));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(10));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(93));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(94));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(95));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(96));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(97));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(98));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(99));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(100));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(101));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(102));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(103));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(104));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(105));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(106));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(107));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(108));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(109));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(110));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(111));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(112));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(113));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(114));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(115));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(116));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(117));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(118));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(119));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(120));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(121));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(122));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(123));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(124));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(125));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(126));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(127));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(128));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(129));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(130));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(131));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(132));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(133));
                Utils.SqlIntAppend(insertSql, 1, baRs.getString(134));
                Utils.SqlStringAppend(insertSql, 1, baRs.getString(135));
                Utils.SqlStringAppend(insertSql, 1, fix);
                Utils.SqlTimeAppend(insertSql, 1, Utils.GetNowTime());
                Utils.SqlStringAppend(insertSql, 1, pactCode);
                Utils.SqlStringAppend(insertSql, 1, insuplcAdmdvs);
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(setlDate));
                Utils.SqlStringAppend(insertSql, 1, typeFlag);
                Utils.SqlStringAppend(insertSql, 1, inpatientNo);
                Utils.SqlStringAppend(insertSql, 0, medicalType);
                ps = conn.prepareStatement(insertSql.toString());
                num = ps.executeUpdate();
                if (num > 0) {
                    getBaglDiseInfo(inpatientNo, fix + inpatientNo, fix, conn, baglConn);
                    getBaglOprnInfo(inpatientNo,fix + inpatientNo,conn, baglConn);
                    getIcuInfo(inpatientNo,fix + inpatientNo,fix,conn);
                }
                ps.close();

            }
            baRs.close();
            baPs.close();
        } catch (Exception e) {

            assert ps != null;
            ps.close();
            OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
            assert insertSql != null;
            operateDataDao.GrabDataErrMsg(conn, mdId, "4401", "2", e.getMessage(), insertSql.toString(), Utils.SqlTimeToDate(setlDate), Utils.GetNowTime());
            e.printStackTrace();
            baRs.close();
            baPs.close();
            e.printStackTrace();
        }
        return num;
    }

    public void getBaglDiseInfo(String inpatientNo, String MDTRT_SN, String FIXMEDINS_CODE, Connection conn, Connection conBagl) throws Exception {
        String sql = "select vd.diag_type,vd.diag_code,vd.diag_name,vd.adm_cond_type,vd.maindiag_flag from V_YB_DISEINFO vd where vd.病人ID='" + inpatientNo + "'";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = conBagl.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                insertSql = new StringBuffer();
                insertSql.append("INSERT INTO DATA_4401_DISEINFO (PALG_NO,MAINDIAG_FLAG,DIAG_CODE,DIAG_NAME,VALI_FLAG,IPT_MEDCAS_HMPG_SN,MDTRT_SN,FIXMEDINS_CODE,grab_time) VALUES (");
                Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                Utils.SqlStringAppend(insertSql, 1, rs.getString(5));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(2));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(3));
                Utils.SqlStringAppend(insertSql, 1, "1");
                Utils.SqlStringAppend(insertSql, 1, inpatientNo);
                Utils.SqlStringAppend(insertSql, 1, MDTRT_SN);
                Utils.SqlStringAppend(insertSql, 1, FIXMEDINS_CODE);
                Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                PreparedStatement psinsertt = conn.prepareStatement(insertSql.toString());
                psinsertt.executeUpdate();
                psinsertt.close();
                insertSql = null;

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(insertSql);
            e.printStackTrace();
        }

    }

    public void getBaglOprnInfo(String inpatientNo,  String MDTRT_SN, Connection conn, Connection conBagl) throws Exception {
        String sql = "SELECT  O.oprn_oprt_date ,O.oprn_oprt_name,O.oprn_oprt_code,O.oper_dr_name, O.anst_dr_name, O.anst_begn_date,O.anst_end_date FROM V_YB_oprninfo O WHERE O.病人ID='"+inpatientNo+"'";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = conBagl.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                insertSql = new StringBuffer();
                insertSql.append("INSERT INTO DATA_4401_OPRNINFO (OPRN_OPRT_DATE,OPRN_OPRT_NAME,OPRN_OPRT_CODE,OPRN_OPRT_SN,OPRN_LV_CODE,OPRN_LV_NAME,OPER_NAME,ASIT1_NAME,ASIT2_NAME,SINC_HEAL_LV,SINC_HEAL_LV_CODE,ANST_MTD_NAME,ANST_MTD_CODE,ANST_DR_NAME,OPRN_OPER_PART,OPRN_OPER_PART_CODE,OPRN_CON_TIME,ANST_LV_NAME,ANST_LV_CODE,OPRN_PATN_TYPE,OPRN_PATN_TYPE_CODE,MAIN_OPRN_FLAG,ANST_ASA_LV_CODE,ANST_ASA_LV_NAME,ANST_MEDN_CODE,ANST_MEDN_NAME,ANST_MEDN_DOS,UNT,ANST_BEGNTIME,ANST_ENDTIME,ANST_COPN_CODE,ANST_COPN_NAME,ANST_COPN_DSCR,PACU_BEGNTIME,PACU_ENDTIME,CANC_OPRN_FLAG,VALI_FLAG,IPT_MEDCAS_HMPG_SN,MDTRT_SN,GRAB_TIME) VALUES (");
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(rs.getString(1)));
                Utils.SqlStringAppend(insertSql, 2, rs.getString(2));
                Utils.SqlStringAppend(insertSql, 3, rs.getString(3));
                Utils.SqlStringAppend(insertSql, 4, "");
                Utils.SqlStringAppend(insertSql, 5, "");
                Utils.SqlStringAppend(insertSql, 6, "");
                Utils.SqlStringAppend(insertSql, 7, rs.getString(4));
                Utils.SqlStringAppend(insertSql, 8, "");
                Utils.SqlStringAppend(insertSql, 9, "");
                Utils.SqlStringAppend(insertSql, 10, "");
                Utils.SqlStringAppend(insertSql, 11, "");
                Utils.SqlStringAppend(insertSql, 12, "");
                Utils.SqlStringAppend(insertSql, 13, "");
                Utils.SqlStringAppend(insertSql, 14, rs.getString(5));
                Utils.SqlStringAppend(insertSql, 15, "");
                Utils.SqlStringAppend(insertSql, 16, "");
                Utils.SqlStringAppend(insertSql, 17, "");
                Utils.SqlStringAppend(insertSql, 18, "");
                Utils.SqlStringAppend(insertSql, 19, "");
                Utils.SqlStringAppend(insertSql, 20, "");
                Utils.SqlStringAppend(insertSql, 21, "");
                Utils.SqlStringAppend(insertSql, 22, "");
                Utils.SqlStringAppend(insertSql, 23, "");
                Utils.SqlStringAppend(insertSql, 24, "");
                Utils.SqlStringAppend(insertSql, 25, "");
                Utils.SqlStringAppend(insertSql, 26, "");
                Utils.SqlStringAppend(insertSql, 27, "");
                Utils.SqlStringAppend(insertSql, 28, "");
                Utils.SqlTimeAppend(insertSql, 29, Utils.SqlTimeToTime(rs.getString(6)));
                Utils.SqlTimeAppend(insertSql, 30, Utils.SqlTimeToTime(rs.getString(7)));
                Utils.SqlStringAppend(insertSql, 31, "");
                Utils.SqlStringAppend(insertSql, 32, "");
                Utils.SqlStringAppend(insertSql, 33, "");
                Utils.SqlTimeAppend(insertSql, 34, Utils.SqlTimeToTime(""));
                Utils.SqlTimeAppend(insertSql, 35, Utils.SqlTimeToTime(""));
                Utils.SqlStringAppend(insertSql, 36, "");
                Utils.SqlStringAppend(insertSql, 37, "1");
                Utils.SqlStringAppend(insertSql, 38, inpatientNo);
                Utils.SqlStringAppend(insertSql, 39, MDTRT_SN);
                Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                PreparedStatement psinsertt = conn.prepareStatement(insertSql.toString());
                psinsertt.executeUpdate();
                psinsertt.close();
                insertSql = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(insertSql);
            e.printStackTrace();
        }

    }
    public void getIcuInfo(String inpatientNo, String MDTRT_SN, String FIXMEDINS_CODE,Connection conn) throws Exception {
        String sql = "select * from V_4401_ICUINFO_GRAB t where t.inp_no='" + inpatientNo + "'";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                insertSql = new StringBuffer();
                insertSql.append("INSERT INTO DATA_4401_ICUINFO (ICU_CODE, INPOOL_ICU_TIME,OUT_ICU_TIME,MEDINS_ORGCODE, NURSCARE_LV_CODE, NURSCARE_LV_NAME,NURSCARE_DAYS,BACK_ICU,VALI_FLAG,IPT_MEDCAS_HMPG_SN,MDTRT_SN,FIXMEDINS_CODE,GRAB_TIME) VALUES (");
                Utils.SqlStringAppend(insertSql, 99, rs.getString(1));
                Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getString(2)));
                Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getString(3)));
                Utils.SqlStringAppend(insertSql, 99, "");
                Utils.SqlStringAppend(insertSql, 1, rs.getString(4));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(5));
                Utils.SqlIntAppend(insertSql, 1, rs.getString(6));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(7));
                Utils.SqlStringAppend(insertSql, 1, "1");
                Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                Utils.SqlStringAppend(insertSql, 1, MDTRT_SN);
                Utils.SqlStringAppend(insertSql, 1, FIXMEDINS_CODE);
                Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                PreparedStatement psinsertt = conn.prepareStatement(insertSql.toString());
                psinsertt.executeUpdate();
                psinsertt.close();
                insertSql = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(insertSql);
            e.printStackTrace();
        }
    }


}
