package com.syy.chen.dao.impl;

import com.google.gson.Gson;
import com.syy.chen.Utils;
import com.syy.chen.bean.jsqd.Input2203ABean;
import com.syy.chen.dao.GrabData4101ADao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrabData4101ADaoImpl implements GrabData4101ADao {
    @Override
    public void getBaglSetlInfo(String inpatientNo, Connection conn, Connection conBagl, String setlIdMain, String psnNo, String setlID, String mdtrtId, String mzType, String typeFlag, String insuplcAdmdvs, String pactCode, String medicalType, String grapTime, String transType, String setlDate, String setlTime, String invoiceNo, String inDate, String outDate) {
        String sql = "select s.hi_no,s.medcasno,s.dcla_time,s.ntly,s.prfs,s.curr_addr,s.emp_name,s.emp_addr,s.emp_tel,s.poscode,s.coner_name,s.patn_rlts,s.coner_addr,s.coner_tel,s.nwb_adm_type,s.nwb_bir_wt,s.nwb_adm_wt,s.opsp_diag_caty,s.opsp_mdtrt_date,s.adm_way,s.trt_type,s.adm_time,s.refldept_dept,s.dscg_time,s.dscg_caty,s.otp_wm_dise,s.wm_dise_code,s.otp_tcm_dise,s.tcm_dise_code,s.vent_used_dura,s.pwcry_bfadm_coma_dura,s.pwcry_afadm_coma_dura,s.spga_nurscare_days,s.lv1_nurscare_days,s.scd_nurscare_days,s.lv3_nurscare_days,s.dscg_way,s.acp_medins_name,s.acp_optins_code,s.bill_code,s.bill_no,s.biz_sn,s.days_rinp_flag_31,s.days_rinp_pup_31,s.chfpdr_code,s.setl_begn_date,s.setl_end_date,s.medins_fill_dept,s.medins_fill_psn,s.resp_nurs_code,s.hi_paymtd from V_YB_SETLINFO  s where s.mdtrt_sn='" + inpatientNo + "'";
        StringBuffer insertSql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PreparedStatement psinsertt = null;
        try {
            ps = conBagl.prepareStatement(sql);
        } catch (Exception e) {
            System.out.println("ERROR5001:" + inpatientNo + "执行病案SetlInfo——SQL语句出错！" + e.getMessage());
            e.printStackTrace();
        }
        try {
            assert ps != null;
            rs = ps.executeQuery();
        } catch (Exception e) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
        while (true) {
            assert rs != null;
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            insertSql = new StringBuffer();
            insertSql.append("insert INTO DATA_4101A_SETLINFO (setl_id_main,psn_no,mdtrt_id,setl_id,hi_no,medcasno,dcla_time,ntly,prfs,curr_addr,emp_name,emp_addr,emp_tel,poscode,coner_name,patn_rlts,coner_addr,coner_tel,nwb_admtype,nwbbirwt,nwbadmwt,opsp_diag_caty,opsp_mdtrt_date,adm_way,trt_type,adm_time,refldept_dept,dscg_time,dscg_caty,otp_wm_dise,wm_dise_code,otptcmdise,tcmdisecode,vent_used_dura,pwcry_bfadm_coma_dura,pwcry_afadm_coma_dura,spga_nurscare_days,lv1_nurscare_days,scd_nurscare_days,lv3_nurscare_days,dscg_way,acp_medins_name,acp_optins_code,bill_code,bill_no,biz_sn,days_rinp_flag_31,days_rinp_pup_31,chfpdr_code,setl_begn_date,setl_end_date,medins_fill_dept,medins_fill_psn,resp_nurs_code,stas_type,hi_paymtd,type_mz,type_flag,insuplc_admdvs,pact_code,medical_type,grap_time,trans_type,invoice_no,setl_date) VALUES (");
            try {
                Utils.SqlStringAppend(insertSql, 99, setlIdMain);
                Utils.SqlStringAppend(insertSql, 99, psnNo);
                Utils.SqlStringAppend(insertSql, 99, mdtrtId);
                Utils.SqlStringAppend(insertSql, 99, setlID);
                Utils.SqlStringAppend(insertSql, 1, rs.getString(1));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(2));
                Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(3)));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(4));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(5));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(6));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(7));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(8));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(9));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(10));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(11));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(12));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(13));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(14));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(15));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(16));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(17));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(18));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(rs.getObject(19)));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(20));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(21));
                Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(inDate));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(23));
                Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(outDate));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(25));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(26));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(27));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(28));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(29));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(30));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(31));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(32));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(33));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(34));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(35));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(36));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(37));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(38));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(39));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(40));
                Utils.SqlStringAppend(insertSql, 1, invoiceNo);
                Utils.SqlStringAppend(insertSql, 1, rs.getString(42));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(43));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(44));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(45));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(setlTime));
                Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(setlTime));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(48));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(49));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(50));
                Utils.SqlStringAppend(insertSql, 1, null);
                Utils.SqlStringAppend(insertSql, 1, rs.getString(51));
                Utils.SqlStringAppend(insertSql, 99, mzType);
                Utils.SqlStringAppend(insertSql, 99, typeFlag);
                Utils.SqlStringAppend(insertSql, 99, insuplcAdmdvs);
                Utils.SqlStringAppend(insertSql, 99, pactCode);
                Utils.SqlStringAppend(insertSql, 99, medicalType);
                Utils.SqlTimeAppend(insertSql, 99, grapTime);
                Utils.SqlStringAppend(insertSql, 99, transType);
                Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                Utils.SqlDateAppend(insertSql, 0, setlDate);
                psinsertt = conn.prepareStatement(insertSql.toString());
                psinsertt.executeUpdate();
                psinsertt.close();
            } catch (Exception e) {
                OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                operateDataDao.GrabDataErrMsg(conn, setlIdMain, "21", "2", e.getMessage(), insertSql.toString(), setlDate, Utils.GetNowTime());
                assert psinsertt != null;
                try {
                    psinsertt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                e.printStackTrace();
            }
        }
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getBaglDiseInfo(String inpatientNo, String setlIdMain, Connection conn, Connection conBagl) {
        String sql = "select vd.diag_type,vd.diag_code,vd.diag_name,vd.adm_cond_type,vd.maindiag_flag from V_YB_DISEINFO vd where vd.病人ID='" + inpatientNo + "'";
        StringBuffer insertSql = null;

        PreparedStatement ps = null;
        try {
            ps = conBagl.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        while (true) {
            PreparedStatement psinsertt = null;
            try {
                assert rs != null;
                if (!rs.next()) break;
                insertSql = new StringBuffer();
                insertSql.append("INSERT INTO DATA_4101A_DISEINFO (setl_id_main,inpatient_no,diag_type,diag_code,diag_name,adm_cond_type,maindiag_flag,grab_time) VALUES (");
                Utils.SqlStringAppend(insertSql, 99, setlIdMain);
                Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                Utils.SqlStringAppend(insertSql, 1, rs.getString(1));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(2));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(3));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(4));
                Utils.SqlStringAppend(insertSql, 1, rs.getString(5));
                Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                psinsertt = conn.prepareStatement(insertSql.toString());
                psinsertt.executeUpdate();
                psinsertt.close();
            } catch (SQLException throwables) {
                OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                operateDataDao.GrabDataErrMsg(conn, setlIdMain, "22", "2", throwables.getMessage(), insertSql.toString(), "0001-01-01", Utils.GetNowTime());
                assert psinsertt != null;
                try {
                    psinsertt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }

        }
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void getBaglOprnInfo(String inpatientNo, String setlIdMain, Connection conn, Connection conBagl) {
        String sql = "select s.oprn_oprt_type,s.oprn_oprt_name,s.oprn_oprt_code,s.anst_way,s.oper_dr_code,s.anst_dr_code,s.oprn_oprt_begn_date,s.oprn_oprt_end_date,s.anst_begn_date,s.anst_end_date from V_YB_oprninfo s where s.病人ID='" + inpatientNo + "'";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = conBagl.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PreparedStatement psinsertt = null;
                try {
                    insertSql = new StringBuffer();
                    insertSql.append("INSERT INTO DATA_4101A_OPRNINFO (setl_id_main,inpatient_no,oprn_oprt_type,oprn_oprt_name,oprn_oprt_code,anst_way,oper_dr_code,anst_dr_code,oprn_oprt_begntime,oprn_oprt_endtime,anst_begntime,anst_endtime,grab_time) VALUES (");
                    Utils.SqlStringAppend(insertSql, 99, setlIdMain);
                    Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(1));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(2));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(3));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(4));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(5));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(6));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(7)));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(8)));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(9)));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(10)));
                    Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                    psinsertt = conn.prepareStatement(insertSql.toString());
                    psinsertt.executeUpdate();
                    psinsertt.close();
                    insertSql = null;
                } catch (Exception e) {
                    OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                    operateDataDao.GrabDataErrMsg(conn, setlIdMain, "23", "2", e.getMessage(), insertSql.toString(), "0001-01-01", Utils.GetNowTime());
                    try {
                        assert psinsertt != null;
                        psinsertt.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getBaglBldInfo(String inpatientNo, String setlIdMain, Connection conn, Connection conBagl) {
        String sql = "select v.bld_cat,v.bld_amt,v.bld_unit from  V_YB_BLDINFO v where v.f_zyh='" + inpatientNo + "'";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = conBagl.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PreparedStatement psinsertt = null;
                try {
                    insertSql = new StringBuffer();
                    insertSql.append("INSERT INTO DATA_4101A_BLDINFO (setl_id_main,inpatient_no,bld_cat,bld_amt,bld_unt,grab_time) VALUES (");
                    Utils.SqlStringAppend(insertSql, 99, setlIdMain);
                    Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(1));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(2));
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(3));
                    Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                    psinsertt = conn.prepareStatement(insertSql.toString());
                    psinsertt.executeUpdate();
                    psinsertt.close();
                    insertSql = null;
                } catch (Exception e) {
                    OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                    operateDataDao.GrabDataErrMsg(conn, setlIdMain, "25", "2", e.getMessage(), insertSql.toString(), "0001-01-01", Utils.GetNowTime());
                    try {
                        assert psinsertt != null;
                        psinsertt.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getIcuInfo(String inpatientNo, String setlIdMain, Connection conn) {
        String sql = "select * from V_4101A_ICUINFO_GRAB t where t.inp_no='" + inpatientNo + "'";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PreparedStatement psinsertt = null;
                try {
                    insertSql = new StringBuffer();
                    insertSql.append("INSERT INTO DATA_4101A_ICUINFO (setl_id_main, scs_cutd_ward_type,scs_cutd_inpool_time, scs_cutd_exit_time, grab_time, invoice_no,scs_cutd_sum_dura) VALUES (");
                    Utils.SqlStringAppend(insertSql, 99, setlIdMain);
                    Utils.SqlStringAppend(insertSql, 1, rs.getString(1));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getString(2)));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getString(3)));
                    Utils.SqlTimeAppend(insertSql, 1, Utils.GetNowTime());
                    Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                    Utils.SqlStringAppend(insertSql, 0, Utils.timeToYb(Utils.SqlTimeToTime(rs.getObject(2)),
                            Utils.SqlTimeToTime(rs.getObject(3))));
                    psinsertt = conn.prepareStatement(insertSql.toString());
                    psinsertt.executeUpdate();
                    psinsertt.close();
                    insertSql = null;
                } catch (Exception e) {
                    OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                    operateDataDao.GrabDataErrMsg(conn, setlIdMain, "24", "2", e.getMessage(), insertSql.toString(), "0001-01-01", Utils.GetNowTime());
                    try {
                        assert psinsertt != null;
                        psinsertt.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(insertSql);
            e.printStackTrace();
        }
    }

    @Override
    public void getHisOpspDiseInfo(String inpatientNo, String setlIdMain, Connection conn, Connection connHis, String mId) {
        String sql = " select s.jysr from si_chs_log s where  s.trade_code='2203A' and s.trade_appcode='0' and s.kh='" + inpatientNo + "'order by operdate desc";
        StringBuffer insertSql = null;
        try {
            PreparedStatement ps = connHis.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Gson gson = new Gson();
                Input2203ABean input2203ABean = gson.fromJson(Utils.clobToString(rs.getClob(1)), Input2203ABean.class);
                if (input2203ABean.getInput().getMdtrtinfo().getMdtrt_id().equals(mId)) {
                    for (int i = 0; i < input2203ABean.getInput().getDiseinfo().length; i++) {
                        PreparedStatement psinsertt = null;
                        try {
                            insertSql = new StringBuffer();
                            insertSql.append("INSERT INTO DATA_4101A_OPSPDISEINFO (setl_id_main, invoice_no,diag_name, diag_code, oprn_oprt_name, oprn_oprt_code,grab_time) VALUES (");
                            Utils.SqlStringAppend(insertSql, 99, setlIdMain);
                            Utils.SqlStringAppend(insertSql, 99, inpatientNo);
                            Utils.SqlStringAppend(insertSql, 1, input2203ABean.getInput().getDiseinfo()[i].getDiag_name());
                            Utils.SqlStringAppend(insertSql, 1, input2203ABean.getInput().getDiseinfo()[i].getDiag_code());
                            Utils.SqlStringAppend(insertSql, 1, null);
                            Utils.SqlStringAppend(insertSql, 1, null);
                            Utils.SqlTimeAppend(insertSql, 0, Utils.GetNowTime());
                            psinsertt = conn.prepareStatement(insertSql.toString());
                            psinsertt.executeUpdate();
                            psinsertt.close();
                            insertSql = null;
                        } catch (Exception e) {
                            assert psinsertt != null;
                            psinsertt.close();
                            OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                            assert insertSql != null;
                            operateDataDao.GrabDataErrMsg(conn, setlIdMain, "12", "1", e.getMessage(), insertSql.toString(), "0001-01-01", Utils.GetNowTime());
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(insertSql);
            e.printStackTrace();
        }
    }

    @Override
    public void getHisMzSetlInfo(String date, Connection con, Connection conHis) throws Exception {
        String sql = "select * from v_grab_4101a_mt_setlinfo  scs where scs.dcla_time >= '" + date + " 00:00:00' and scs.dcla_time <= '" + date + " 23:59:59'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        PreparedStatement psinsertt = null;
        while (rs.next()) {
            StringBuffer insertSql = new StringBuffer();
            insertSql.append("insert INTO DATA_4101A_SETLINFO (setl_id_main,psn_no,mdtrt_id,setl_id,hi_no,medcasno,dcla_time,ntly,prfs,curr_addr,emp_name,emp_addr,emp_tel,poscode,coner_name,patn_rlts,coner_addr,coner_tel,nwb_admtype,nwbbirwt,nwbadmwt,opsp_diag_caty,opsp_mdtrt_date,adm_way,trt_type,adm_time,refldept_dept,dscg_time,dscg_caty,otp_wm_dise,wm_dise_code,otptcmdise,tcmdisecode,vent_used_dura,pwcry_bfadm_coma_dura,pwcry_afadm_coma_dura,spga_nurscare_days,lv1_nurscare_days,scd_nurscare_days,lv3_nurscare_days,dscg_way,acp_medins_name,acp_optins_code,bill_code,bill_no,biz_sn,days_rinp_flag_31,days_rinp_pup_31,chfpdr_code,setl_begn_date,setl_end_date,medins_fill_dept,medins_fill_psn,resp_nurs_code,stas_type,hi_paymtd,type_mz,type_flag,insuplc_admdvs,pact_code,medical_type,grap_time,trans_type,invoice_no,setl_date) VALUES (");
            String setlIdMain = rs.getObject(4).toString() + "-" + rs.getObject(62).toString();
            Utils.SqlStringAppend(insertSql, 99, setlIdMain);
            Utils.SqlStringAppend(insertSql, 99, rs.getString(2));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(3));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(4));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(5));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(6));
            Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(7)));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(8));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(9));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(10));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(11));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(12));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(13));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(14));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(15));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(16));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(17));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(18));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(19));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(20));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(21));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(22));
            Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(rs.getObject(23)));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(24));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(25));
            Utils.SqlTimeAppend(insertSql, 1, Utils.SqlTimeToTime(rs.getObject(26)));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(27));
            Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(rs.getObject(28)));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(29));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(30));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(31));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(32));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(33));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(34));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(35));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(36));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(37));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(38));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(39));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(40));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(41));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(42));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(43));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(44));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(45));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(46));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(47));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(48));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(49));
            Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(rs.getObject(50)));
            Utils.SqlDateAppend(insertSql, 1, Utils.SqlTimeToDate(rs.getObject(51)));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(52));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(53));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(54));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(55));
            Utils.SqlStringAppend(insertSql, 1, rs.getString(56));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(57));
            Utils.SqlStringAppend(insertSql, 99, Utils.YbFenLei(rs.getObject(59).toString()));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(59));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(60));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(61));
            Utils.SqlTimeAppend(insertSql, 99, Utils.GetNowTime());
            Utils.SqlStringAppend(insertSql, 99, rs.getString(62));
            Utils.SqlStringAppend(insertSql, 99, rs.getString(6));
            Utils.SqlDateAppend(insertSql, 0, date);
            try {
                psinsertt = con.prepareStatement(insertSql.toString());
                psinsertt.executeUpdate();
                psinsertt.close();
                insertSql = null;
                getHisOpspDiseInfo(rs.getObject(6).toString(), setlIdMain, con, conHis, rs.getObject(3).toString());
            } catch (SQLException ignored) {
                assert psinsertt != null;
                psinsertt.close();
                OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
                assert insertSql != null;
                operateDataDao.GrabDataErrMsg(con, setlIdMain, "11", "1", ignored.getMessage(), insertSql.toString(), date, Utils.GetNowTime());
                ignored.printStackTrace();
            }
        }
        rs.close();
        ps.close();
    }


    @Override
    public void getHisZySetlInfoList(String date, int typeCode, Connection conn, Connection baglConn) throws Exception {
        String sql = "select * from V_4101A_HIS sc where sc.type_code='2' and sc.setl_time >= '" + date + " 00:00:00' and sc.setl_time <= '" + date + " 23:59:59'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String setlIdMain = null;
            String inpatientNo = null;
            try {
                setlIdMain = rs.getString(3) + "-" + rs.getObject(8).toString();
                inpatientNo = rs.getString(9);
            } catch (SQLException throwables) {
                System.out.println("ERROR001:获取setl失败或获取tran_type失败:" + throwables.getMessage());
                throwables.printStackTrace();
            }
            try {
                switch (typeCode) {
                    case 0:
                        getBaglSetlInfo(inpatientNo, conn, baglConn, setlIdMain, rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4), Utils.YbFenLei(rs.getString(5)), rs.getString(5), rs.getString(6), rs.getString(7), Utils.GetNowTime(), rs.getString(8), date, rs.getString(10), rs.getString(12), rs.getString(13), rs.getString(14));
                        getBaglDiseInfo(inpatientNo, setlIdMain, conn, baglConn);
                        getBaglOprnInfo(inpatientNo, setlIdMain, conn, baglConn);
                        getBaglBldInfo(inpatientNo, setlIdMain, conn, baglConn);
                        getIcuInfo(inpatientNo, setlIdMain, conn);
                        break;
                    case 1:
                        getBaglSetlInfo(inpatientNo, conn, baglConn, setlIdMain, rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4), Utils.YbFenLei(rs.getString(5)), rs.getString(5), rs.getString(6), rs.getString(7), Utils.GetNowTime(), rs.getString(8), date, rs.getString(10), rs.getString(12), rs.getString(13), rs.getString(14));
                        break;
                    case 2:
                        getBaglDiseInfo(inpatientNo, setlIdMain, conn, baglConn);
                        break;
                    case 3:
                        getBaglOprnInfo(inpatientNo, setlIdMain, conn, baglConn);
                        break;
                    case 4:
                        getIcuInfo(inpatientNo, setlIdMain, conn);
                        break;
                    case 5:
                        getBaglBldInfo(inpatientNo, setlIdMain, conn, baglConn);
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERROR002:抓取信息失败:" + setlIdMain + e.getMessage());
                e.printStackTrace();
            }
        }
        rs.close();
        ps.close();
    }

}
