package com.syy.chen.dao.impl;

import com.syy.chen.Utils;
import com.syy.chen.bean.HomeDataBean;
import com.syy.chen.dao.HomeDataDao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HomeDataDaoImpl implements HomeDataDao {
    @Override
    public HomeDataBean getData(int num) throws Exception {
        String sql = "select decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all1," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 1) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all1," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all2," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 2) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all2," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all3," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 3) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all3," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all4," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 4) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all4," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all5," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 5) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all5," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='1'and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') then 1 else 0 end)) grds_mz_all6," +
                "decode (sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num + 6) + "','yyyy-mm-dd') then 1 else 0 end)) grds_zy_all6," +
                "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc,"+
               "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc1," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+1) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc1,"+
               "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc2," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+2) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc2,"+
               "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc3," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+3) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc3,"+
               "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc4," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+4) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc4,"+
               "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc5," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+5) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc5,"+
               "decode (sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and  (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc6," +
                "decode (sum(case when ds.type_mz='2'and ds.setl_date>=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.setl_date>=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + Utils.getDateBefore(num+6) + "','yyyy-mm-dd') and (ds.upload_state_cds ='0' or ds.upload_state_scs ='0')  then 1 else 0 end)) upload_mzsucc6"+
                " from data_4101a_setlinfo ds ";
        HomeDataBean homeDataBean = null;
        try {
            DrgsDataTool hisSql = new DrgsDataTool();
            Connection conn = hisSql.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                homeDataBean = new HomeDataBean(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17),
                        rs.getInt(18),
                        rs.getInt(19),
                        rs.getInt(20),
                        rs.getInt(21),
                        rs.getInt(22),
                        rs.getInt(23),
                        rs.getInt(24),
                        rs.getInt(25),
                        rs.getInt(26),
                        rs.getInt(27),
                        rs.getInt(28),
                        Utils.getDateBefore(num),
                        Utils.getDateBefore(num+1),
                        Utils.getDateBefore(num+2),
                        Utils.getDateBefore(num+3),
                        Utils.getDateBefore(num+4),
                        Utils.getDateBefore(num+5),
                        Utils.getDateBefore(num+6)
                );
            }
            String sqlHis = "select sum(case when s.med_type ='14' and s.type_code ='1' and  s.valid_flag = '1' and s.setl_time >='" + Utils.getDateBefore(num) + " 00:00:00' and s.setl_time <='" + Utils.getDateBefore(num) + " 23:59:59' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%' ) then 1 else 0 end) his_mz_all,sum(case when s.type_code ='2' and  s.valid_flag = '1' and s.setl_time >='" + Utils.getDateBefore(num) + " 00:00:00' and s.setl_time <='" + Utils.getDateBefore(num) + " 23:59:59' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%' ) then 1 else 0 end) his_zy_all from si_chs_setl_info@his50 s";
            hisSql.close(ps);
            hisSql.close(rs);
            ps = conn.prepareStatement(sqlHis);
            rs = ps.executeQuery();
            while (rs.next()) {
                homeDataBean.setHisMzALL(rs.getInt(1));
                homeDataBean.setHisZyALL(rs.getInt(2));
            }
            hisSql.close(ps);
            hisSql.close(rs);
            hisSql.myConnClose(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
;
        return homeDataBean;
    }

}
