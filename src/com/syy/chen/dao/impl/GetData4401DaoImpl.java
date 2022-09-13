package com.syy.chen.dao.impl;

import com.syy.chen.Utils;
import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.bean.zysy.*;
import com.syy.chen.dao.GetData4401Dao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetData4401DaoImpl implements GetData4401Dao {
    @Override
    public WebTableDataBean getSimpleData(String limit, String page, String beginDate, String endDate, String chsType, String setlId, String state) throws Exception {
        ArrayList<BaseInfoBean> arrayDate = new ArrayList<>();
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
                where = where + " and t.mdtrt_sn ='" + setlId + "'";
            } else {
                where = where + " where t.mdtrt_sn ='" + setlId + "'";
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
        if (state != null && !state.equals("")) {
            switch (state) {
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
        String sql = "select * from (select ROWNUM rn ,t.* from V_4401_BASEINFO_SIMPLE t " + where + " ) sr where sr.rn >" + satrt + " and sr.rn <=" + end;
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
                whereCount = whereCount + " and t.mdtrt_sn ='" + setlId + "'";
            } else {
                whereCount = whereCount + " where t.mdtrt_sn ='" + setlId + "'";
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
        if (state != null && !state.equals("")) {
            switch (state) {
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
        String sqlCount = "select count(*) as total  from V_4401_BASEINFO_SIMPLE t" + whereCount;
        DrgsDataTool hisSql = new DrgsDataTool();
        Connection conn = hisSql.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            BaseInfoBean setlInfo4101ABean = new BaseInfoBean(
                    rs.getString("mdtrt_sn"),
                    rs.getString("mdtrt_id"),
                    rs.getString("psn_no"),
                    rs.getString("psn_name"),
                    rs.getString("adm_date"),
                    rs.getString("dscg_date"),
                    rs.getString("trade_serial_cds"),
                    rs.getString("upload_time_cds"),
                    rs.getInt("upload_state_cds"),
                    rs.getString("grab_time"),
                    rs.getString("type_flag"),
                    rs.getString("upload_time_scs"),
                    rs.getInt("upload_state_scs"),
                    rs.getString("trade_serial_scs"),
                    rs.getString("setl_date"),
                    rs.getString("insuplc_admdvs"));
            if (setlInfo4101ABean.getType_flag().equals("1")) {
                setlInfo4101ABean.setUpload_state(Integer.toString(setlInfo4101ABean.getUpload_state_cds()));
                setlInfo4101ABean.setUpload_time(setlInfo4101ABean.getUpload_time_cds());
                setlInfo4101ABean.setTrade_serial(setlInfo4101ABean.getTrade_serial_cds());
            } else {
                setlInfo4101ABean.setUpload_state(Integer.toString(setlInfo4101ABean.getUpload_state_scs()));
                setlInfo4101ABean.setUpload_time(setlInfo4101ABean.getUpload_time_scs());
                setlInfo4101ABean.setTrade_serial(setlInfo4101ABean.getTrade_serial_scs());
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
    public Data4401Bean getBaseInfo4401(String inpatient_no, Connection conn, boolean isUpload) throws Exception {
        Data4401Bean data4401Beans = null;
        BaseInfoBean baseInfoBean = null;
        ArrayList<DiseInfo4401Bean> diseInfo4401Beans = null;
        ArrayList<OprnInfo4401Bean> oprnInfo4401Beans = null;
        ArrayList<IcuInfo4401Bean> icuInfo4401Beans = null;
        //查询SetlInfo 信息
        String sql = "select * from V_4401_BASEINFO_ALL s where s.inpatient_no ='" + inpatient_no + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (isUpload) {
                baseInfoBean = new BaseInfoBean(
                 /*       Utils.sqlNullToString(rs.getString(1)),
                        Utils.sqlNullToString(rs.getString(2)),
                        Utils.sqlNullToString(rs.getString(3)),
                        Utils.sqlNullToString(rs.getString(4)),
                        Utils.sqlNullToString(rs.getString(5)),
                        Utils.sqlNullToString(rs.getString(6)),
                        Utils.sqlNullToString(rs.getString(7)),
                        Utils.sqlNullToString(rs.getString(8)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(9))),
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
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(45))),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(46))),
                        Utils.sqlNullToString(rs.getString(47)),
                        Utils.sqlNullToString(rs.getString(48)),
                        Utils.sqlNullToString(rs.getString(49)),
                        Utils.sqlNullToString(rs.getString(50)),
                        Utils.sqlNullToString(rs.getString(51)),
                        Utils.sqlNullToString(rs.getString(52)),
                        Utils.sqlNullToString(rs.getString(53)),
                        Utils.sqlNullToString(rs.getString(54)),
                        Utils.sqlNullToString(rs.getString(55)),
                        Utils.sqlNullToString(rs.getString(56)),
                        Utils.sqlNullToString(rs.getString(57)),
                        Utils.sqlNullToString(rs.getString(58)),
                        Utils.sqlNullToString(rs.getString(59)),
                        Utils.sqlNullToString(rs.getString(60)),
                        Utils.sqlNullToString(rs.getString(61)),
                        Utils.sqlNullToString(rs.getString(62)),
                        Utils.sqlNullToString(rs.getString(63)),
                        Utils.sqlNullToString(rs.getString(64)),
                        Utils.sqlNullToString(rs.getString(65)),
                        Utils.sqlNullToString(rs.getString(66)),
                        Utils.sqlNullToString(rs.getString(67)),
                        Utils.sqlNullToString(rs.getString(68)),
                        Utils.sqlNullToString(rs.getString(69)),
                        Utils.sqlNullToString(rs.getString(70)),
                        Utils.sqlNullToString(rs.getString(71)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(72))),
                        Utils.sqlNullToString(rs.getString(73)),
                        Utils.sqlNullToString(rs.getString(74)),
                        Utils.sqlNullToString(rs.getString(75)),
                        Utils.sqlNullToString(rs.getString(76)),
                        Utils.sqlNullToString(rs.getString(77)),
                        Utils.sqlNullToString(rs.getString(78)),
                        Utils.sqlNullToString(rs.getString(79)),
                        Utils.sqlNullToString(rs.getString(80)),
                        Utils.sqlNullToString(rs.getString(81)),
                        Utils.sqlNullToString(rs.getString(82)),
                        Utils.sqlNullToString(rs.getString(83)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(84))),
                        Utils.sqlNullToString(rs.getString(85)),
                        Utils.sqlNullToString(rs.getString(86)),
                        Utils.sqlNullToString(rs.getString(87)),
                        Utils.sqlNullToString(rs.getString(88)),
                        Utils.sqlNullToString(rs.getString(89)),
                        Utils.sqlNullToString(rs.getString(90)),
                        Utils.sqlNullToString(rs.getString(91)),
                        Utils.sqlNullToString(rs.getString(92)),
                        Utils.sqlNullToString(rs.getString(93)),
                        Utils.sqlNullToString(rs.getString(94)),
                        Utils.sqlNullToString(rs.getString(95)),
                        Utils.sqlNullToString(rs.getString(96)),
                        Utils.sqlNullToString(rs.getString(97)),
                        Utils.sqlNullToString(rs.getString(98)),
                        Utils.sqlNullToString(rs.getString(99)),
                        Utils.sqlNullToString(rs.getString(100)),
                        Utils.sqlNullToString(rs.getString(101)),
                        Utils.sqlNullToString(rs.getString(102)),
                        Utils.sqlNullToString(rs.getString(103)),
                        Utils.sqlNullToString(rs.getString(104)),
                        Utils.sqlNullToString(rs.getString(105)),
                        Utils.sqlNullToString(rs.getString(106)),
                        Utils.sqlNullToString(rs.getString(107)),
                        Utils.sqlNullToString(rs.getString(108)),
                        Utils.sqlNullToString(rs.getString(109)),
                        Utils.sqlNullToString(rs.getString(110)),
                        Utils.sqlNullToString(rs.getString(111)),
                        Utils.sqlNullToString(rs.getString(112)),
                        Utils.sqlNullToString(rs.getString(113)),
                        Utils.sqlNullToString(rs.getString(114)),
                        Utils.sqlNullToString(rs.getString(115)),
                        Utils.sqlNullToString(rs.getString(116)),
                        Utils.sqlNullToString(rs.getString(117)),
                        Utils.sqlNullToString(rs.getString(118)),
                        Utils.sqlNullToString(rs.getString(119)),
                        Utils.sqlNullToString(rs.getString(120)),
                        Utils.sqlNullToString(rs.getString(121)),
                        Utils.sqlNullToString(rs.getString(122)),
                        Utils.sqlNullToString(rs.getString(123)),
                        Utils.sqlNullToString(rs.getString(124)),
                        Utils.sqlNullToString(rs.getString(125)),
                        Utils.sqlNullToString(rs.getString(126)),
                        Utils.sqlNullToString(rs.getString(127)),
                        Utils.sqlNullToString(rs.getString(128)),
                        Utils.sqlNullToString(rs.getString(129)),
                        Utils.sqlNullToString(rs.getString(130)),
                        Utils.sqlNullToString(rs.getString(131)),
                        Utils.sqlNullToString(rs.getString(132)),
                        Utils.sqlNullToString(rs.getString(133)),
                        Utils.sqlNullToString(rs.getString(134)),
                        Utils.sqlNullToString(rs.getString(135)),
                        Utils.sqlNullToString(rs.getString(136)));*/
                        Utils.sqlNullToString(rs.getString(1)),
                        Utils.sqlNullToString(rs.getString(2)),
                        Utils.sqlNullToString(rs.getString(3)),
                        Utils.sqlNullToString(rs.getString(4)),
                        Utils.sqlNullToString(rs.getString(5)),
                        Utils.sqlNullToString(rs.getString(6)),
                        Utils.sqlNullToString(rs.getString(7)),
                        Utils.sqlNullToString(rs.getString(8)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(9))),
                        Utils.sqlNullToString(rs.getString(10)),
                        Utils.sqlNullToString(rs.getString(11)),
                        rs.getFloat(12),
                        rs.getFloat(13),
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
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(45))),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(46))),
                        Utils.sqlNullToString(rs.getString(47)),
                        Utils.sqlNullToString(rs.getString(48)),
                        Utils.sqlNullToString(rs.getString(49)),
                        rs.getInt(50),
                        Utils.sqlNullToString(rs.getString(51)),
                        Utils.sqlNullToString(rs.getString(52)),
                        Utils.sqlNullToString(rs.getString(53)),
                        Utils.sqlNullToString(rs.getString(54)),
                        Utils.sqlNullToString(rs.getString(55)),
                        Utils.sqlNullToString(rs.getString(56)),
                        Utils.sqlNullToString(rs.getString(57)),
                        Utils.sqlNullToString(rs.getString(58)),
                        Utils.sqlNullToString(rs.getString(59)),
                        Utils.sqlNullToString(rs.getString(60)),
                        Utils.sqlNullToString(rs.getString(61)),
                        Utils.sqlNullToString(rs.getString(62)),
                        Utils.sqlNullToString(rs.getString(63)),
                        Utils.sqlNullToString(rs.getString(64)),
                        Utils.sqlNullToString(rs.getString(65)),
                        Utils.sqlNullToString(rs.getString(66)),
                        Utils.sqlNullToString(rs.getString(67)),
                        Utils.sqlNullToString(rs.getString(68)),
                        Utils.sqlNullToString(rs.getString(69)),
                        Utils.sqlNullToString(rs.getString(70)),
                        Utils.sqlNullToString(rs.getString(71)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(72))),
                        Utils.sqlNullToString(rs.getString(73)),
                        Utils.sqlNullToString(rs.getString(74)),
                        Utils.sqlNullToString(rs.getString(75)),
                        Utils.sqlNullToString(rs.getString(76)),
                        Utils.sqlNullToString(rs.getString(77)),
                        Utils.sqlNullToString(rs.getString(78)),
                        Utils.sqlNullToString(rs.getString(79)),
                        Utils.sqlNullToString(rs.getString(80)),
                        Utils.sqlNullToString(rs.getString(81)),
                        Utils.sqlNullToString(rs.getString(82)),
                        Utils.sqlNullToString(rs.getString(83)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(84))),
                        Utils.sqlNullToString(rs.getString(85)),
                        Utils.sqlNullToString(rs.getString(86)),
                        Utils.sqlNullToString(rs.getString(87)),
                        Utils.sqlNullToString(rs.getString(88)),
                        Utils.sqlNullToString(rs.getString(89)),
                        Utils.sqlNullToString(rs.getString(90)),
                        Utils.sqlNullToString(rs.getString(91)),
                        rs.getFloat(92),
                        Utils.sqlNullToString(rs.getString(93)),
                        Utils.sqlNullToString(rs.getString(94)),
                        Utils.sqlNullToString(rs.getString(95)),
                        Utils.sqlNullToString(rs.getString(96)),
                        Utils.sqlNullToString(rs.getString(97)),
                        rs.getInt(98),
                        rs.getInt(99),
                        Utils.sqlNullToString(rs.getString(100)),
                        Utils.sqlNullToString(rs.getString(101)),
                        Utils.sqlNullToString(rs.getString(102)),
                        Utils.sqlNullToString(rs.getString(103)),
                        Utils.sqlNullToString(rs.getString(104)),
                        rs.getFloat(105),
                        rs.getFloat(106),
                        rs.getFloat(107),
                        rs.getFloat(108),
                        rs.getFloat(109),
                        rs.getFloat(110),
                        rs.getFloat(111),
                        rs.getFloat(112),
                        rs.getFloat(113),
                        rs.getFloat(114),
                        rs.getFloat(115),
                        rs.getFloat(116),
                        rs.getFloat(117),
                        rs.getFloat(118),
                        rs.getFloat(119),
                        rs.getFloat(120),
                        rs.getFloat(121),
                        rs.getFloat(122),
                        rs.getFloat(123),
                        rs.getFloat(124),
                        rs.getFloat(125),
                        rs.getFloat(126),
                        rs.getFloat(127),
                        rs.getFloat(128),
                        rs.getFloat(129),
                        rs.getFloat(130),
                        rs.getFloat(131),
                        rs.getFloat(132),
                        rs.getFloat(133),
                        rs.getFloat(134),
                        Utils.sqlNullToString(rs.getString(135)),
                        Utils.sqlNullToString(rs.getString(136)));



            } else {
                baseInfoBean = new BaseInfoBean(
                        Utils.sqlNullToString(rs.getString(1)),
                        Utils.sqlNullToString(rs.getString(2)),
                        Utils.sqlNullToString(rs.getString(3)),
                        Utils.sqlNullToString(rs.getString(4)),
                        Utils.sqlNullToString(rs.getString(5)),
                        Utils.sqlNullToString(rs.getString(6)),
                        Utils.sqlNullToString(rs.getString(7)),
                        Utils.sqlNullToString(rs.getString(8)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(9))),
                        Utils.sqlNullToString(rs.getString(10)),
                        Utils.sqlNullToString(rs.getString(11)),
                        rs.getFloat(12),
                        rs.getFloat(13),
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
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(45))),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(46))),
                        Utils.sqlNullToString(rs.getString(47)),
                        Utils.sqlNullToString(rs.getString(48)),
                        Utils.sqlNullToString(rs.getString(49)),
                        rs.getInt(50),
                        Utils.sqlNullToString(rs.getString(51)),
                        Utils.sqlNullToString(rs.getString(52)),
                        Utils.sqlNullToString(rs.getString(53)),
                        Utils.sqlNullToString(rs.getString(54)),
                        Utils.sqlNullToString(rs.getString(55)),
                        Utils.sqlNullToString(rs.getString(56)),
                        Utils.sqlNullToString(rs.getString(57)),
                        Utils.sqlNullToString(rs.getString(58)),
                        Utils.sqlNullToString(rs.getString(59)),
                        Utils.sqlNullToString(rs.getString(60)),
                        Utils.sqlNullToString(rs.getString(61)),
                        Utils.sqlNullToString(rs.getString(62)),
                        Utils.sqlNullToString(rs.getString(63)),
                        Utils.sqlNullToString(rs.getString(64)),
                        Utils.sqlNullToString(rs.getString(65)),
                        Utils.sqlNullToString(rs.getString(66)),
                        Utils.sqlNullToString(rs.getString(67)),
                        Utils.sqlNullToString(rs.getString(68)),
                        Utils.sqlNullToString(rs.getString(69)),
                        Utils.sqlNullToString(rs.getString(70)),
                        Utils.sqlNullToString(rs.getString(71)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(72))),
                        Utils.sqlNullToString(rs.getString(73)),
                        Utils.sqlNullToString(rs.getString(74)),
                        Utils.sqlNullToString(rs.getString(75)),
                        Utils.sqlNullToString(rs.getString(76)),
                        Utils.sqlNullToString(rs.getString(77)),
                        Utils.sqlNullToString(rs.getString(78)),
                        Utils.sqlNullToString(rs.getString(79)),
                        Utils.sqlNullToString(rs.getString(80)),
                        Utils.sqlNullToString(rs.getString(81)),
                        Utils.sqlNullToString(rs.getString(82)),
                        Utils.sqlNullToString(rs.getString(83)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(84))),
                        Utils.sqlNullToString(rs.getString(85)),
                        Utils.sqlNullToString(rs.getString(86)),
                        Utils.sqlNullToString(rs.getString(87)),
                        Utils.sqlNullToString(rs.getString(88)),
                        Utils.sqlNullToString(rs.getString(89)),
                        Utils.sqlNullToString(rs.getString(90)),
                        Utils.sqlNullToString(rs.getString(91)),
                        rs.getFloat(92),
                        Utils.sqlNullToString(rs.getString(93)),
                        Utils.sqlNullToString(rs.getString(94)),
                        Utils.sqlNullToString(rs.getString(95)),
                        Utils.sqlNullToString(rs.getString(96)),
                        Utils.sqlNullToString(rs.getString(97)),
                        rs.getInt(98),
                        rs.getInt(99),
                        Utils.sqlNullToString(rs.getString(100)),
                        Utils.sqlNullToString(rs.getString(101)),
                        Utils.sqlNullToString(rs.getString(102)),
                        Utils.sqlNullToString(rs.getString(103)),
                        Utils.sqlNullToString(rs.getString(104)),
                        rs.getFloat(105),
                        rs.getFloat(106),
                        rs.getFloat(107),
                        rs.getFloat(108),
                        rs.getFloat(109),
                        rs.getFloat(110),
                        rs.getFloat(111),
                        rs.getFloat(112),
                        rs.getFloat(113),
                        rs.getFloat(114),
                        rs.getFloat(115),
                        rs.getFloat(116),
                        rs.getFloat(117),
                        rs.getFloat(118),
                        rs.getFloat(119),
                        rs.getFloat(120),
                        rs.getFloat(121),
                        rs.getFloat(122),
                        rs.getFloat(123),
                        rs.getFloat(124),
                        rs.getFloat(125),
                        rs.getFloat(126),
                        rs.getFloat(127),
                        rs.getFloat(128),
                        rs.getFloat(129),
                        rs.getFloat(130),
                        rs.getFloat(131),
                        rs.getFloat(132),
                        rs.getFloat(133),
                        rs.getFloat(134),
                        Utils.sqlNullToString(rs.getString(135)),
                        Utils.sqlNullToString(rs.getString(136)),
                        Utils.sqlNullToString(rs.getString(137)),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString(138))),
                        rs.getInt(139),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString(140))),
                        Utils.sqlNullToString(rs.getString(141)),
                        Utils.sqlNullToString(rs.getString(142)),
                        Utils.sqlNullToString(Utils.SqlTimeToTime(rs.getString(143))),
                        rs.getInt(144),
                        Utils.sqlNullToString(rs.getString(145)),
                        Utils.sqlNullToString(rs.getString(146)),
                        Utils.sqlNullToString(rs.getString(147)),
                        Utils.sqlNullToString(rs.getString(148)),
                        Utils.sqlNullToString(Utils.SqlTimeToDate(rs.getString(149))));
            }
        }
        ps.close();
        rs.close();

        //查询DiseInfo信息
        sql = "select * from v_4401_diseinfo  d where d.palg_no = '" + inpatient_no + "' ";
        PreparedStatement psDise = conn.prepareStatement(sql);
        ResultSet rsDise = psDise.executeQuery();
        while (rsDise.next()) {
            if (diseInfo4401Beans == null) {
                diseInfo4401Beans = new ArrayList<>();
            }
            DiseInfo4401Bean diseInfo4101ABean = new DiseInfo4401Bean(
                    Utils.sqlNullToString(rsDise.getString(1)),
                    Utils.sqlNullToString(rsDise.getString(2)),
                    Utils.sqlNullToString(rsDise.getString(3)),
                    Utils.sqlNullToString(rsDise.getString(4)),
                    Utils.sqlNullToString(rsDise.getString(5)),
                    Utils.sqlNullToString(rsDise.getString(6)),
                    Utils.sqlNullToString(rsDise.getString(7)),
                    Utils.sqlNullToString(rsDise.getString(8)),
                    Utils.sqlNullToString(rsDise.getString(9)),
                    Utils.sqlNullToString(rsDise.getString(10)),
                    Utils.sqlNullToString(rsDise.getString(11)),
                    Utils.sqlNullToString(rsDise.getString(12)),
                    Utils.sqlNullToString(rsDise.getString(13)),
                    Utils.sqlNullToString(rsDise.getString(14)),
                    Utils.sqlNullToString(rsDise.getString(15)),
                    Utils.sqlNullToString(rsDise.getString(16)),
                    Utils.sqlNullToString(rsDise.getString(17)),
                    Utils.sqlNullToString(rsDise.getString(18)),
                    Utils.sqlNullToString(rsDise.getString(19)));
            diseInfo4401Beans.add(diseInfo4101ABean);
        }
        psDise.close();
        rsDise.close();

        //查询oprn手术信息
        sql = "select * from V_4401_OPRNINFO o where o.IPT_MEDCAS_HMPG_SN ='" + inpatient_no + "'";
        PreparedStatement psOprn = conn.prepareStatement(sql);
        ResultSet rsOprn = psOprn.executeQuery();
        while (rsOprn.next()) {
            if (oprnInfo4401Beans == null) {
                oprnInfo4401Beans = new ArrayList<>();
            }
            OprnInfo4401Bean oprnInfo4101ABean = new OprnInfo4401Bean(
                    Utils.sqlNullToString(Utils.SqlTimeToDate(rsOprn.getString(1))),
                    Utils.sqlNullToString(rsOprn.getString(2)),
                    Utils.sqlNullToString(rsOprn.getString(3)),
                    Utils.sqlNullToString(rsOprn.getString(4)),
                    Utils.sqlNullToString(rsOprn.getString(5)),
                    Utils.sqlNullToString(rsOprn.getString(6)),
                    Utils.sqlNullToString(rsOprn.getString(7)),
                    Utils.sqlNullToString(rsOprn.getString(8)),
                    Utils.sqlNullToString(rsOprn.getString(9)),
                    Utils.sqlNullToString(rsOprn.getString(10)),
                    Utils.sqlNullToString(rsOprn.getString(11)),
                    Utils.sqlNullToString(rsOprn.getString(12)),
                    Utils.sqlNullToString(rsOprn.getString(13)),
                    Utils.sqlNullToString(rsOprn.getString(14)),
                    Utils.sqlNullToString(rsOprn.getString(15)),
                    Utils.sqlNullToString(rsOprn.getString(16)),
                    Utils.sqlNullToString(rsOprn.getString(17)),
                    Utils.sqlNullToString(rsOprn.getString(18)),
                    Utils.sqlNullToString(rsOprn.getString(19)),
                    Utils.sqlNullToString(rsOprn.getString(20)),
                    Utils.sqlNullToString(rsOprn.getString(21)),
                    Utils.sqlNullToString(rsOprn.getString(22)),
                    Utils.sqlNullToString(rsOprn.getString(23)),
                    Utils.sqlNullToString(rsOprn.getString(24)),
                    Utils.sqlNullToString(rsOprn.getString(25)),
                    Utils.sqlNullToString(rsOprn.getString(26)),
                    Utils.sqlNullToString(rsOprn.getString(27)),
                    Utils.sqlNullToString(rsOprn.getString(28)),
                    Utils.sqlNullToString(Utils.SqlTimeToTime(rsOprn.getString(29))),
                    Utils.sqlNullToString(Utils.SqlTimeToTime(rsOprn.getString(30))),
                    Utils.sqlNullToString(rsOprn.getString(31)),
                    Utils.sqlNullToString(rsOprn.getString(32)),
                    Utils.sqlNullToString(rsOprn.getString(33)),
                    Utils.sqlNullToString(Utils.SqlTimeToTime(rsOprn.getString(34))),
                    Utils.sqlNullToString(Utils.SqlTimeToTime(rsOprn.getString(35))),
                    Utils.sqlNullToString(rsOprn.getString(36)),
                    Utils.sqlNullToString(rsOprn.getString(37)),
                    Utils.sqlNullToString(rsOprn.getString(38)),
                    Utils.sqlNullToString(rsOprn.getString(39)));
            oprnInfo4401Beans.add(oprnInfo4101ABean);
        }
        psOprn.close();
        rsOprn.close();

        //查询IcuInfo信息
        sql = "select * from v_4401_icuinfo t where t.IPT_MEDCAS_HMPG_SN='" + inpatient_no + "'";
        PreparedStatement psICU = conn.prepareStatement(sql);
        ResultSet rsICU = psICU.executeQuery();
        while (rsICU.next()) {
            if (icuInfo4401Beans == null) {
                icuInfo4401Beans = new ArrayList<>();
            }
            IcuInfo4401Bean icuInfo4101ABean = new IcuInfo4401Bean(
                    Utils.sqlNullToString(rsICU.getString(1)),
                    Utils.sqlNullToString(Utils.SqlTimeToDate(rsICU.getString(2))),
                    Utils.sqlNullToString(Utils.SqlTimeToDate(rsICU.getString(3))),
                    Utils.sqlNullToString(rsICU.getString(4)),
                    Utils.sqlNullToString(rsICU.getString(5)),
                    Utils.sqlNullToString(rsICU.getString(6)),
                    Utils.sqlNullToString(rsICU.getString(7)),
                    Utils.sqlNullToString(rsICU.getString(8)),
                    Utils.sqlNullToString(rsICU.getString(9)),
                    Utils.sqlNullToString(rsICU.getString(10)),
                    Utils.sqlNullToString(rsICU.getString(11)),
                    Utils.sqlNullToString(rsICU.getString(12)));
            icuInfo4401Beans.add(icuInfo4101ABean);
        }
        psICU.close();
        rsICU.close();

        data4401Beans = new Data4401Bean(baseInfoBean, diseInfo4401Beans, oprnInfo4401Beans, icuInfo4401Beans);
        return data4401Beans;

    }

}
