package com.syy.chen.dao.impl;

import com.syy.chen.bean.zysy.BaoBiao4401Bean;
import com.syy.chen.dao.BaoBiao4401Dao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaoBiao4401DaoImpl implements BaoBiao4401Dao {
    @Override
    public BaoBiao4401Bean getBaoBiaoData(String beginDate, String endDate) throws Exception {
        BaoBiao4401Bean baoBiao4401Bean = null;
        String sql = "select  decode (sum(case when  ds.type_flag='1' then 1 else 0 end),'',0,sum(case when ds.type_flag='1' then 1 else 0 end)) grds_cds, decode (sum(case when  ds.type_flag='2' then 1 else 0 end),'',0,sum(case when ds.type_flag='2' then 1 else 0 end)) grds_scs, decode (sum(case when ds.type_flag='1' and ds.upload_state_cds ='0' then 1 else 0 end),'',0,sum(case when ds.type_flag='1' and ds.upload_state_cds ='0' then 1 else 0 end)) upload_cds_succ, decode (sum(case when ds.type_flag='1' and ds.upload_state_cds ='-1' then 1 else 0 end),'',0,sum(case when  ds.type_flag='1' and ds.upload_state_cds ='-1' then 1 else 0 end)) upload_cds_fail, decode (sum(case when ds.type_flag='1' and ds.upload_state_cds ='-2' then 1 else 0 end),'',0,sum(case when  ds.type_flag='1' and ds.upload_state_cds ='-2' then 1 else 0 end)) upload_cds_no, decode (sum(case when ds.type_flag='2' and ds.upload_state_scs ='0' then 1 else 0 end),'',0,sum(case when ds.type_flag='2' and ds.upload_state_scs ='0' then 1 else 0 end)) upload_mz_scs_succ, decode (sum(case when ds.type_flag='2' and ds.upload_state_scs ='-1' then 1 else 0 end),'',0,sum(case when ds.type_flag='2' and ds.upload_state_scs ='-1' then 1 else 0 end)) upload_mz_scs_fail, decode (sum(case when ds.type_flag='2' and ds.upload_state_scs ='-2' then 1 else 0 end),'',0,sum(case when ds.type_flag='2' and ds.upload_state_scs ='-2' then 1 else 0 end)) upload_mz_scs_no from data_4401_baseinfo ds where ds.setl_date>=to_date('"+beginDate+"','yyyy-mm-dd') and ds.setl_date<=to_date('"+endDate+"','yyyy-mm-dd')";
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection conn = drgsDataTool.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            baoBiao4401Bean = new BaoBiao4401Bean(rs.getInt("grds_cds"),
                    rs.getInt("grds_scs"),
                    rs.getInt("upload_cds_succ"),
                    rs.getInt("upload_cds_fail"),
                    rs.getInt("upload_cds_no"),
                    rs.getInt("upload_mz_scs_succ"),
                    rs.getInt("upload_mz_scs_fail"),
                    rs.getInt("upload_mz_scs_no"));
        }
        drgsDataTool.close(rs);
        drgsDataTool.close(ps);
        sql = "select decode(sum(case when s.type_code ='2' and s.insuplc_admdvs like '5101%' then 1 else 0 end),'',0,sum(case when s.type_code ='2' and s.insuplc_admdvs like '5101%' then 1 else 0 end)) his_zy_cds, decode(sum(case when s.type_code ='2' and s.insuplc_admdvs like '5199%' then 1 else 0 end),'',0,sum(case when s.type_code ='2' and s.insuplc_admdvs like '5199%' then 1 else 0 end)) his_zy_scs from si_chs_setl_info@his50 s where  s.valid_flag = '1' and s.setl_time >='" + beginDate + " 00:00:00' and s.setl_time <='" + endDate + " 23:59:59'";
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            baoBiao4401Bean.setHisCds(rs1.getInt("his_zy_cds"));
            baoBiao4401Bean.setHisScs(rs1.getInt("his_zy_scs"));
        }
        drgsDataTool.close(rs1);
        drgsDataTool.close(ps1);
        drgsDataTool.myConnClose(conn);
        return baoBiao4401Bean;
    }
}
