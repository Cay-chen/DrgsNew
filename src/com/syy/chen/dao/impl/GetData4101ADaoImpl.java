package com.syy.chen.dao.impl;

import com.syy.chen.Utils;
import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.bean.jsqd.*;
import com.syy.chen.dao.GetData4101ADao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetData4101ADaoImpl implements GetData4101ADao {
    @Override
    public WebTableDataBean getSimpleData(String limit, String page, String beginDate, String endDate, String mzType, String chsType, String setlId, String state) throws Exception {
        ArrayList<SetlInfo4101ABean> arrayDate = new ArrayList<>();
        int Count = 0;
        String where = "";
        if (beginDate != null && !beginDate.equals("")) {
            where = where + " where t.setl_date >= to_date('" + beginDate + "','yyyy-MM-dd')";
        }
        if (endDate != null && !endDate.equals("")) {
            if (!where.equals("")) {
                where = where + " and t.setl_date <= to_date('" + endDate + "','yyyy-MM-dd')";
            } else {
                where = where + " where t.setl_date <= to_date('" + endDate + "','yyyy-MM-dd')";
            }
        }
        if (setlId != null && !setlId.equals("")) {
            if (!where.equals("")) {
                where = where + " and t.setl_id ='" + setlId + "'";
            } else {
                where = where + " where t.setl_id ='" + setlId + "'";
            }
        }
        if (mzType != null && !mzType.equals("")) {
            switch (mzType) {
                case "1":
                    if (!where.equals("")) {
                        where = where + " and t.type_mz ='1'";
                    } else {
                        where = where + " where t.type_mz ='1'";
                    }
                    break;
                case "2":
                    if (!where.equals("")) {
                        where = where + " and t.type_mz ='2'";
                    } else {
                        where = where + " where t.type_mz ='2'";
                    }
                    break;
            }
        }
        if (chsType != null && !chsType.equals("")) {
            switch (chsType) {
                case "1":
                    if (!where.equals("")) {
                        where = where + " and t.type_flag ='1'";
                    } else {
                        where = where + " where t.type_flag ='1'";
                    }
                    break;
                case "2":
                    if (!where.equals("")) {
                        where = where + " and t.type_flag ='2'";
                    } else {
                        where = where + " where t.type_flag ='2'";
                    }
                    break;
                case "3":
                    if (!where.equals("")) {
                        where = where + " and t.type_flag ='3'";
                    } else {
                        where = where + " where t.type_flag ='3'";
                    }
                    break;
                case "4":
                    if (!where.equals("")) {
                        where = where + " and t.type_flag ='4'";
                    } else {
                        where = where + " where t.type_flag ='4'";
                    }
                    break;
            }
        }
        if (state != null && !state.equals("")){
            switch (state){
                case "1":
                    if (!where.equals("")) {
                        where = where + " and (t.UPLOAD_STATE_CDS='0' or t.UPLOAD_STATE_SCS='0')";
                    } else {
                        where = where + " where (t.UPLOAD_STATE_CDS='0' or t.UPLOAD_STATE_SCS='0')";
                    }
                    break;
                case "-1":
                    if (!where.equals("")) {
                        where = where + " and (t.UPLOAD_STATE_CDS='-1' or t.UPLOAD_STATE_SCS='-1')";
                    } else {
                        where = where + " where (t.UPLOAD_STATE_CDS='-1' or t.UPLOAD_STATE_SCS='-1')";
                    }
                    break;
                case "-2":
                    if (!where.equals("")) {
                        where = where + " and t.UPLOAD_STATE_CDS='-2' and t.UPLOAD_STATE_SCS='-2'";
                    } else {
                        where = where + " where t.UPLOAD_STATE_CDS='-2' and t.UPLOAD_STATE_SCS='-2'";
                    }
                    break;
            }
        }
        int satrt = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        int end = Integer.parseInt(limit) * Integer.parseInt(page);
        String sql = "select * from (select ROWNUM rn ,t.* from V_4101A_SETLINFO_SIMPLE t " + where + " ) sr where sr.rn >" + satrt + " and sr.rn <=" + end;
        /*------------------------------------------------------------------*/

        String whereCount = "";
        if (beginDate != null && !beginDate.equals("")) {
            if (whereCount != "") {
                whereCount = whereCount + " and t.setl_date >= to_date('" + beginDate + "','yyyy-MM-dd')";
            } else {
                whereCount = whereCount + " where t.setl_date >= to_date('" + beginDate + "','yyyy-MM-dd')";
            }
        }
        if (endDate != null && !endDate.equals("")) {
            if (whereCount != "") {
                whereCount = whereCount + " and t.setl_date <= to_date('" + endDate + "','yyyy-MM-dd')";
            } else {
                whereCount = whereCount + " where t.setl_date <= to_date('" + endDate + "','yyyy-MM-dd')";
            }
        }
        if (setlId != null && !setlId.equals("")) {
            if (whereCount != "") {
                whereCount = whereCount + " and t.setl_id ='" + setlId + "'";
            } else {
                whereCount = whereCount + " where t.setl_id ='" + setlId + "'";
            }
        }
        if (mzType != null && !mzType.equals("")) {
            switch (mzType) {
                case "1":
                    if (whereCount != "") {
                        whereCount = whereCount + " and t.type_mz ='1'";
                    } else {
                        whereCount = whereCount + " where t.type_mz ='1'";
                    }
                    break;
                case "2":
                    if (whereCount != "") {
                        whereCount = whereCount + " and t.type_mz ='2'";
                    } else {
                        whereCount = whereCount + " where t.type_mz ='2'";
                    }
                    break;
            }

        }
        if (chsType != null && !chsType.equals("")) {
            switch (chsType) {
                case "1":
                    if (whereCount != "") {
                        whereCount = whereCount + " and t.type_flag ='1'";
                    } else {
                        whereCount = whereCount + " where t.type_flag ='1'";
                    }
                    break;
                case "2":
                    if (whereCount != "") {
                        whereCount = whereCount + " and t.type_flag ='2'";
                    } else {
                        whereCount = whereCount + " where t.type_flag ='2'";
                    }
                    break;
                case "3":
                    if (whereCount != "") {
                        whereCount = whereCount + " and t.type_flag ='3'";
                    } else {
                        whereCount = whereCount + " where t.type_flag ='3'";
                    }
                    break;
                case "4":
                    if (whereCount != "") {
                        whereCount = whereCount + " and t.type_flag ='4'";
                    } else {
                        whereCount = whereCount + " where t.type_flag ='4'";
                    }
                    break;
            }
        }
        if (state != null && !state.equals("")){
            switch (state){
                case "1":
                    if (!where.equals("")) {
                        whereCount = where + " and (t.UPLOAD_STATE_CDS='0' or t.UPLOAD_STATE_SCS='0')";
                    } else {
                        whereCount = where + " where (t.UPLOAD_STATE_CDS='0' or t.UPLOAD_STATE_SCS='0')";
                    }
                    break;
                case "-1":
                    if (!where.equals("")) {
                        whereCount = where + " and (t.UPLOAD_STATE_CDS='-1' or t.UPLOAD_STATE_SCS='-1')";
                    } else {
                        whereCount = where + " where (t.UPLOAD_STATE_CDS='-1' or t.UPLOAD_STATE_SCS='-1')";
                    }
                    break;
                case "-2":
                    if (!where.equals("")) {
                        whereCount = where + " and t.UPLOAD_STATE_CDS='-2' and t.UPLOAD_STATE_SCS='-2'";
                    } else {
                        whereCount = where + " where t.UPLOAD_STATE_CDS='-2' and t.UPLOAD_STATE_SCS='-2'";
                    }
                    break;
            }
        }
        String sqlCount = "select count(*) as total  from V_4101A_SETLINFO_SIMPLE t" + whereCount;
        DrgsDataTool hisSql = new DrgsDataTool();
        Connection conn = hisSql.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SetlInfo4101ABean setlInfo4101ABean = new SetlInfo4101ABean(
                    rs.getString("psn_no"),
                    rs.getString("setl_id"),
                    rs.getString("medcasno"),
                    rs.getString("mdtrt_id"),
                    rs.getString("dcla_time"),
                    rs.getString("type_mz"),
                    rs.getString("insuplc_admdvs"),
                    rs.getString("pact_code"),
                    rs.getString("trans_type"),
                    rs.getString("grap_time"),
                    rs.getString("upload_time_cds"),
                    rs.getString("upload_state_cds"),
                    rs.getString("setl_list_id_cds"),
                    rs.getString("upload_time_scs"),
                    rs.getString("upload_state_scs"),
                    rs.getString("setl_list_id_scs"),
                    rs.getString("type_flag"),
                    rs.getString("invoice_no"),
                    rs.getString("setl_date"));
            if (setlInfo4101ABean.getType_flag().equals("1")) {
                setlInfo4101ABean.setUpload_state(setlInfo4101ABean.getUpload_state_cds());
                setlInfo4101ABean.setUpload_time(setlInfo4101ABean.getUpload_time_cds());
                setlInfo4101ABean.setSetl_list_id(setlInfo4101ABean.getSetl_list_id_cds());
            } else {
                setlInfo4101ABean.setUpload_state(setlInfo4101ABean.getUpload_state_scs());
                setlInfo4101ABean.setUpload_time(setlInfo4101ABean.getUpload_time_scs());
                setlInfo4101ABean.setSetl_list_id(setlInfo4101ABean.getSetl_list_id_scs());
            }
            arrayDate.add(setlInfo4101ABean);
        }
        hisSql.close(ps);
        hisSql.close(rs);
        PreparedStatement psCount = conn.prepareStatement(sqlCount);
        ResultSet rsCount = psCount.executeQuery();
        while (rsCount.next()) {
            Count = rsCount.getInt("total");
        }
        hisSql.close(psCount);
        hisSql.close(rsCount);
        hisSql.myConnClose(conn);
        return new WebTableDataBean(0, arrayDate, Count, "成功！");
    }

    @Override
    public Data4101ABean getData4101A(String setlIdMain, String mzType,Connection conn, boolean isUpload) throws Exception {
        Data4101ABean Data4101ABeans = null;
        SetlInfo4101ABean setlInfo4101ABean = null;
        ArrayList<DiseInfo4101ABean> diseInfo4101ABeans = null;
        ArrayList<OprnInfo4101ABean> oprnInfo4101ABeans = null;
        ArrayList<IcuInfo4101ABean> icuInfo4101ABeans = null;
        ArrayList<BldInfo4101ABean> bldInfo4101ABeans = null;
        ArrayList<OpspDiseInfo4101ABean> opspDiseInfo4101ABeans = null;
        //查询SetlInfo 信息
        String sql = "select * from V_4101A_SETLINFO_ALL s where s.setl_id_main ='" + setlIdMain + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (isUpload) {
                setlInfo4101ABean = new SetlInfo4101ABean(
                        Utils.sqlNullToString(rs.getString(2)),
                        Utils.sqlNullToString(rs.getString(3)),
                        Utils.sqlNullToString(rs.getString(4)),
                        Utils.sqlNullToString(rs.getString(5)),
                        Utils.sqlNullToString(rs.getString(6)),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString(7))),
                        Utils.sqlNullToString(rs.getString(8)),
                        Utils.sqlNullToString(rs.getString(9)),
                        Utils.sqlNullToString(rs.getString(10)),
                        Utils.sqlNullToString(rs.getString(11)),
                        Utils.sqlNullToString(rs.getString(12)),
                        Utils.sqlNullToString(rs.getString(13)),
                        Utils.sqlNullToString(rs.getString(14)),
                        Utils.sqlNullToString(rs.getString(15)),
                        Utils.sqlNullToString(rs.getString(16)),
                        Utils.sqlNullToString(rs.getString(17)),
                        Utils.sqlNullToString(rs.getString(18)),
                        Utils.sqlNullToString(rs.getString(19)),
                        Utils.sqlNullToString(rs.getString(20)),
                        Utils.sqlNullToString(rs.getString(21)),
                        Utils.sqlNullToString(rs.getString(22)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(23))),
                        Utils.sqlNullToString(rs.getString(24)),
                        Utils.sqlNullToString(rs.getString(25)),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString(26))),
                        Utils.sqlNullToString(rs.getString(27)),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString(28))),
                        Utils.sqlNullToString(rs.getString(29)),
                        Utils.sqlNullToString(rs.getString(30)),
                        Utils.sqlNullToString(rs.getString(31)),
                        Utils.sqlNullToString(rs.getString(32)),
                        Utils.sqlNullToString(rs.getString(33)),
                        Utils.sqlNullToString(rs.getString(34)),
                        Utils.sqlNullToString(rs.getString(35)),
                        Utils.sqlNullToString(rs.getString(36)),
                        Utils.sqlNullToString(rs.getString(37)),
                        Utils.sqlNullToString(rs.getString(38)),
                        Utils.sqlNullToString(rs.getString(39)),
                        Utils.sqlNullToString(rs.getString(40)),
                        Utils.sqlNullToString(rs.getString(41)),
                        Utils.sqlNullToString(rs.getString(42)),
                        Utils.sqlNullToString(rs.getString(43)),
                        Utils.sqlNullToString(rs.getString(44)),
                        Utils.sqlNullToString(rs.getString(45)),
                        Utils.sqlNullToString(rs.getString(46)),
                        Utils.sqlNullToString(rs.getString(47)),
                        Utils.sqlNullToString(rs.getString(48)),
                        Utils.sqlNullToString(rs.getString(49)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(50))),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(51))),
                        Utils.sqlNullToString(rs.getString(52)),
                        Utils.sqlNullToString(rs.getString(53)),
                        Utils.sqlNullToString(rs.getString(54)),
                        Utils.sqlNullToString(rs.getString(55)),
                        Utils.sqlNullToString(rs.getString(56)));
            } else {
                setlInfo4101ABean = new SetlInfo4101ABean(
                        Utils.sqlNullToString(rs.getString("acp_medins_name")),
                        Utils.sqlNullToString(rs.getString("acp_optins_code")),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString("adm_time"))),
                        Utils.sqlNullToString(rs.getString("adm_way")),
                        Utils.sqlNullToString(rs.getString("bill_code")),
                        Utils.sqlNullToString(rs.getString("bill_no")),
                        Utils.sqlNullToString(rs.getString("biz_sn")),
                        Utils.sqlNullToString(rs.getString("chfpdr_code")),
                        Utils.sqlNullToString(rs.getString("coner_addr")),
                        Utils.sqlNullToString(rs.getString("coner_name")),
                        Utils.sqlNullToString(rs.getString("coner_tel")),
                        Utils.sqlNullToString(rs.getString("curr_addr")),
                        Utils.sqlNullToString(rs.getString("days_rinp_flag_31")),
                        Utils.sqlNullToString(rs.getString("days_rinp_pup_31")),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString("dcla_time"))),
                        Utils.sqlNullToString(rs.getString("dscg_caty")),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString("dscg_time"))),
                        Utils.sqlNullToString(rs.getString("dscg_way")),
                        Utils.sqlNullToString(rs.getString("emp_addr")),
                        Utils.sqlNullToString(rs.getString("emp_name")),
                        Utils.sqlNullToString(rs.getString("emp_tel")),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString("grap_time"))),
                        Utils.sqlNullToString(rs.getString("hi_no")),
                        Utils.sqlNullToString(rs.getString("hi_paymtd")),
                        Utils.sqlNullToString(rs.getString("insuplc_admdvs")),
                        Utils.sqlNullToString(rs.getString("lv1_nurscare_days")),
                        Utils.sqlNullToString(rs.getString("lv3_nurscare_days")),
                        Utils.sqlNullToString(rs.getString("mdtrt_id")),
                        Utils.sqlNullToString(rs.getString("medcasno")),
                        Utils.sqlNullToString(rs.getString("medical_type")),
                        Utils.sqlNullToString(rs.getString("medins_fill_dept")),
                        Utils.sqlNullToString(rs.getString("medins_fill_psn")),
                        Utils.sqlNullToString(rs.getString("ntly")),
                        Utils.sqlNullToString(rs.getString("nwb_admtype")),
                        Utils.sqlNullToString(rs.getString("nwbadmwt")),
                        Utils.sqlNullToString(rs.getString("nwbbirwt")),
                        Utils.sqlNullToString(rs.getString("opsp_diag_caty")),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString("opsp_mdtrt_date"))),
                        Utils.sqlNullToString(rs.getString("otp_wm_dise")),
                        Utils.sqlNullToString(rs.getString("otptcmdise")),
                        Utils.sqlNullToString(rs.getString("pact_code")),
                        Utils.sqlNullToString(rs.getString("patn_rlts")),
                        Utils.sqlNullToString(rs.getString("poscode")),
                        Utils.sqlNullToString(rs.getString("prfs")),
                        Utils.sqlNullToString(rs.getString("psn_no")),
                        Utils.sqlNullToString(rs.getString("pwcry_afadm_coma_dura")),
                        Utils.sqlNullToString(rs.getString("pwcry_bfadm_coma_dura")),
                        Utils.sqlNullToString(rs.getString("refldept_dept")),
                        Utils.sqlNullToString(rs.getString("resp_nurs_code")),
                        Utils.sqlNullToString(rs.getString("scd_nurscare_days")),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString("setl_begn_date"))),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString("setl_end_date"))),
                        Utils.sqlNullToString(rs.getString("setl_id")),
                        Utils.sqlNullToString(rs.getString("setl_id_main")),
                        Utils.sqlNullToString(rs.getString("setl_list_id_cds")),
                        Utils.sqlNullToString(rs.getString("setl_list_id_scs")),
                        Utils.sqlNullToString(rs.getString("spga_nurscare_days")),
                        Utils.sqlNullToString(rs.getString("stas_type")),
                        Utils.sqlNullToString(rs.getString("tcmdisecode")),
                        Utils.sqlNullToString(rs.getString("trans_type")),
                        Utils.sqlNullToString(rs.getString("trt_type")),
                        Utils.sqlNullToString(rs.getString("type_flag")),
                        Utils.sqlNullToString(rs.getString("type_mz")),
                        Utils.sqlNullToString(rs.getString("upload_state_cds")),
                        Utils.sqlNullToString(rs.getString("upload_state_scs")),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString("upload_time_cds"))),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString("upload_time_scs"))),
                        Utils.sqlNullToString(rs.getString("vent_used_dura")),
                        Utils.sqlNullToString(rs.getString("wm_dise_code")),
                        Utils.sqlNullToString(rs.getString("invoice_no")),
                        Utils.sqlNullToString(rs.getString("setl_date")));

            }
        }
        ps.close();
        rs.close();
        if (mzType.equals("1")) {
            sql = "select vo.* from v_4101a_opspdiseinfo vo where vo.setl_id_main ='" + setlIdMain + "' ";
            PreparedStatement psOpsp = conn.prepareStatement(sql);
            ResultSet rsOpsp = psOpsp.executeQuery();
            while (rsOpsp.next()) {
                if (opspDiseInfo4101ABeans == null) {
                    opspDiseInfo4101ABeans = new ArrayList<>();
                }
                OpspDiseInfo4101ABean opspDiseInfo4101ABean = new OpspDiseInfo4101ABean(
                        rsOpsp.getString("diag_name"),
                        rsOpsp.getString("diag_code"),
                        rsOpsp.getString("oprn_oprt_name"),
                        rsOpsp.getString("oprn_oprt_code"));
                opspDiseInfo4101ABeans.add(opspDiseInfo4101ABean);
            }
            psOpsp.close();
            rsOpsp.close();
        } else {
            //查询DiseInfo信息
            sql = "select * from v_4101a_diseinfo  d where d.setl_id_main = '" + setlIdMain + "' ";
            PreparedStatement psDise = conn.prepareStatement(sql);
            ResultSet rsDise = psDise.executeQuery();
            while (rsDise.next()) {
                if (diseInfo4101ABeans == null) {
                    diseInfo4101ABeans = new ArrayList<>();
                }
                DiseInfo4101ABean diseInfo4101ABean = new DiseInfo4101ABean(
                        rsDise.getString("diag_type"),
                        rsDise.getString("diag_code"),
                        rsDise.getString("diag_name"),
                        rsDise.getString("adm_cond_type"),
                        rsDise.getString("maindiag_flag"));
                diseInfo4101ABeans.add(diseInfo4101ABean);
            }
            psDise.close();
            rsDise.close();

            //查询oprn手术信息
            sql = "select * from V_4101A_OPRNINFO o where o.setl_id_main ='" + setlIdMain + "'";
            PreparedStatement psOprn = conn.prepareStatement(sql);
            ResultSet rsOprn = psOprn.executeQuery();
            while (rsOprn.next()) {
                if (oprnInfo4101ABeans == null) {
                    oprnInfo4101ABeans = new ArrayList<>();
                }
                OprnInfo4101ABean oprnInfo4101ABean = new OprnInfo4101ABean(
                        rsOprn.getString("oprn_oprt_type"),
                        rsOprn.getString("oprn_oprt_name"),
                        rsOprn.getString("oprn_oprt_code"),
                        rsOprn.getString("anst_way"),
                        rsOprn.getString("oper_dr_code"),
                        rsOprn.getString("anst_dr_code"),
                        Utils.SqlTimeToTime(rsOprn.getString("oprn_oprt_begntime")),
                        Utils.SqlTimeToTime(rsOprn.getString("oprn_oprt_endtime")),
                        Utils.SqlTimeToTime(rsOprn.getString("anst_begntime")),
                        Utils.SqlTimeToTime(rsOprn.getString("anst_endtime")));
                oprnInfo4101ABeans.add(oprnInfo4101ABean);
            }
            psOprn.close();
            rsOprn.close();

            //查询IcuInfo信息
            sql = "select * from V_4101A_ICUINFO t where t.setl_id_main='" + setlIdMain + "'";
            PreparedStatement psICU = conn.prepareStatement(sql);
            ResultSet rsICU = psICU.executeQuery();
            while (rsICU.next()) {
                if (icuInfo4101ABeans == null) {
                    icuInfo4101ABeans = new ArrayList<>();
                }
                IcuInfo4101ABean icuInfo4101ABean = new IcuInfo4101ABean(
                        rsICU.getString("scs_cutd_ward_type"),
                        Utils.SqlTimeToTime(rsICU.getString("scs_cutd_inpool_time")),
                        Utils.SqlTimeToTime(rsICU.getString("scs_cutd_exit_time")),
                        rsICU.getString("scs_cutd_sum_dura"));
                icuInfo4101ABeans.add(icuInfo4101ABean);
            }
            psICU.close();
            rsICU.close();
            //查询Bld 输血信息
            sql = "select * from V_4101A_BLDINFO t where t.setl_id_main='" + setlIdMain + "'";
            PreparedStatement psBld = conn.prepareStatement(sql);
            ResultSet rsBld = psBld.executeQuery();
            while (rsBld.next()) {
                if (bldInfo4101ABeans == null) {
                    bldInfo4101ABeans = new ArrayList<>();
                }
                BldInfo4101ABean bldInfo4101ABean = new BldInfo4101ABean(
                        rsBld.getString("bld_cat"),
                        rsBld.getFloat("bld_amt"),
                        rsBld.getString("bld_unt"));
                bldInfo4101ABeans.add(bldInfo4101ABean);
            }
            psBld.close();
            rsBld.close();
        }
        Data4101ABeans = new Data4101ABean(setlInfo4101ABean, diseInfo4101ABeans, oprnInfo4101ABeans, icuInfo4101ABeans, bldInfo4101ABeans, opspDiseInfo4101ABeans);
        return Data4101ABeans;

    }

/*    @Override
    public SetlInfo4101ABean getSetlInfo4101AUplodData(String setlInMain, Connection conn) throws Exception {
        String sql = "select * from v_4101A_setlinfo  s where s.setl_id_main='" + setlInMain + "'";
        SetlInfo4101ABean setlInfo4101ABean = null;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            setlInfo4101ABean = new SetlInfo4101ABean(
                    Utils.sqlNullToString(rs.getString(1)),
                    Utils.sqlNullToString(rs.getString(2)),
                    Utils.sqlNullToString(rs.getString(3)),
                    Utils.sqlNullToString(rs.getString(4)),
                    Utils.sqlNullToString(rs.getString(5)),
                    Utils.sqlNullToString(rs.getString(6)),
                    Utils.sqlNullToString(rs.getString(7)),
                    Utils.sqlNullToString(rs.getString(8)),
                    Utils.sqlNullToString(rs.getString(9)),
                    Utils.sqlNullToString(rs.getString(10)),
                    Utils.sqlNullToString(rs.getString(11)),
                    Utils.sqlNullToString(rs.getString(12)),
                    Utils.sqlNullToString(rs.getString(13)),
                    Utils.sqlNullToString(rs.getString(14)),
                    Utils.sqlNullToString(rs.getString(15)),
                    Utils.sqlNullToString(rs.getString(16)),
                    Utils.sqlNullToString(rs.getString(17)),
                    Utils.sqlNullToString(rs.getString(18)),
                    Utils.sqlNullToString(rs.getString(19)),
                    Utils.sqlNullToString(rs.getString(20)),
                    Utils.sqlNullToString(rs.getString(21)),
                    Utils.sqlNullToString(rs.getString(22)),
                    Utils.sqlNullToString(rs.getString(23)),
                    Utils.sqlNullToString(rs.getString(24)),
                    Utils.sqlNullToString(rs.getString(25)),
                    Utils.sqlNullToString(rs.getString(26)),
                    Utils.sqlNullToString(rs.getString(27)),
                    Utils.sqlNullToString(rs.getString(28)),
                    Utils.sqlNullToString(rs.getString(29)),
                    Utils.sqlNullToString(rs.getString(30)),
                    Utils.sqlNullToString(rs.getString(31)),
                    Utils.sqlNullToString(rs.getString(32)),
                    Utils.sqlNullToString(rs.getString(33)),
                    Utils.sqlNullToString(rs.getString(34)),
                    Utils.sqlNullToString(rs.getString(35)),
                    Utils.sqlNullToString(rs.getString(36)),
                    Utils.sqlNullToString(rs.getString(37)),
                    Utils.sqlNullToString(rs.getString(38)),
                    Utils.sqlNullToString(rs.getString(39)),
                    Utils.sqlNullToString(rs.getString(40)),
                    Utils.sqlNullToString(rs.getString(41)),
                    Utils.sqlNullToString(rs.getString(42)),
                    Utils.sqlNullToString(rs.getString(43)),
                    Utils.sqlNullToString(rs.getString(44)),
                    Utils.sqlNullToString(rs.getString(45)),
                    Utils.sqlNullToString(rs.getString(46)),
                    Utils.sqlNullToString(rs.getString(47)),
                    Utils.sqlNullToString(rs.getString(48)),
                    Utils.sqlNullToString(rs.getString(49)),
                    Utils.sqlNullToString(rs.getString(50)),
                    Utils.sqlNullToString(rs.getString(51)),
                    Utils.sqlNullToString(rs.getString(52)),
                    Utils.sqlNullToString(rs.getString(53)),
                    Utils.sqlNullToString(rs.getString(54)),
                    Utils.sqlNullToString(rs.getString(55)));

        }
        return setlInfo4101ABean;
    }*/

}
