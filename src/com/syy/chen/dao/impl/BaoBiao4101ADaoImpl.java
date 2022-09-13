package com.syy.chen.dao.impl;

import com.syy.chen.bean.jsqd.BaoBiao4101ABean;
import com.syy.chen.dao.BaoBiao4101ADao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaoBiao4101ADaoImpl implements BaoBiao4101ADao {
    @Override
    public BaoBiao4101ABean getBaoBiaoData(String beginDate, String endDate) throws Exception {
        BaoBiao4101ABean baoBiao4101ABean = null;
        String sql = "select  count(*) grds_all, decode (sum(case when ds.type_mz='1' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' then 1 else 0 end)) grds_mz_al, decode (sum(case when ds.type_mz='1' and ds.type_flag='1' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='1' then 1 else 0 end)) grds_mz_cds, decode (sum(case when ds.type_mz='1' and ds.type_flag='2' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='2' then 1 else 0 end)) grds_mz_scs, decode (sum(case when ds.type_mz='2' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' then 1 else 0 end)) grds_zy_all, decode (sum(case when ds.type_mz='2' and ds.type_flag='1' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='1' then 1 else 0 end)) grds_zy_cds, decode (sum(case when ds.type_mz='2' and ds.type_flag='2' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='2' then 1 else 0 end)) grds_zy_scs, decode (sum(case when ds.type_mz='1' and ds.type_flag='1' and ds.upload_state_cds ='0' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='1' and ds.upload_state_cds ='0' then 1 else 0 end)) upload_mz_cds_succ, decode (sum(case when ds.type_mz='1' and ds.type_flag='1' and ds.upload_state_cds ='-1' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='1' and ds.upload_state_cds ='-1' then 1 else 0 end)) upload_mz_cds_fail, decode (sum(case when ds.type_mz='1' and ds.type_flag='1' and ds.upload_state_cds ='-2' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='1' and ds.upload_state_cds ='-2' then 1 else 0 end)) upload_mz_cds_no, decode (sum(case when ds.type_mz='1' and ds.type_flag='2' and ds.upload_state_scs ='0' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='2' and ds.upload_state_scs ='0' then 1 else 0 end)) upload_mz_scs_succ, decode (sum(case when ds.type_mz='1' and ds.type_flag='2' and ds.upload_state_scs ='-1' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='2' and ds.upload_state_scs ='-1' then 1 else 0 end)) upload_mz_scs_fail, decode (sum(case when ds.type_mz='1' and ds.type_flag='2' and ds.upload_state_scs ='-2' then 1 else 0 end),'',0,sum(case when ds.type_mz='1' and ds.type_flag='2' and ds.upload_state_scs ='-2' then 1 else 0 end)) upload_mz_scs_no, decode (sum(case when ds.type_mz='2' and ds.type_flag='1' and ds.upload_state_cds ='0' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='1' and ds.upload_state_cds ='0' then 1 else 0 end)) upload_zy_cds_succ, decode (sum(case when ds.type_mz='2' and ds.type_flag='1' and ds.upload_state_cds ='-1' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='1' and ds.upload_state_cds ='-1' then 1 else 0 end)) upload_zy_cds_fail, decode (sum(case when ds.type_mz='2' and ds.type_flag='1' and ds.upload_state_cds ='-2' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='1' and ds.upload_state_cds ='-2' then 1 else 0 end)) upload_zy_cds_no, decode (sum(case when ds.type_mz='2' and ds.type_flag='2' and ds.upload_state_scs ='0' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='2' and ds.upload_state_scs ='0' then 1 else 0 end)) upload_zy_scs_succ, decode (sum(case when ds.type_mz='2' and ds.type_flag='2' and ds.upload_state_scs ='-1' then 1 else 0 end),'',0,sum(case when ds.type_mz='2' and ds.type_flag='2' and ds.upload_state_scs ='-1' then 1 else 0 end)) upload_zy_scs_fail, decode (sum(case when ds.type_mz='2' and ds.type_flag='2' and ds.upload_state_scs ='-2' then 1 else 0 end) ,'',0,sum(case when ds.type_mz='2' and ds.type_flag='2' and ds.upload_state_scs ='-2' then 1 else 0 end))upload_zy_scs_no from data_4101a_setlinfo ds where ds.setl_date>=to_date('" + beginDate + "','yyyy-mm-dd') and ds.setl_date<=to_date('" + endDate + "','yyyy-mm-dd')";
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection conn = drgsDataTool.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            baoBiao4101ABean = new BaoBiao4101ABean(rs.getInt("grds_all"),
                    rs.getInt("grds_mz_al"),
                    rs.getInt("grds_mz_cds"),
                    rs.getInt("grds_mz_scs"),
                    rs.getInt("grds_zy_all"),
                    rs.getInt("grds_zy_cds"),
                    rs.getInt("grds_zy_scs"),
                    rs.getInt("upload_mz_cds_succ"),
                    rs.getInt("upload_mz_cds_fail"),
                    rs.getInt("upload_mz_cds_no"),
                    rs.getInt("upload_mz_scs_succ"),
                    rs.getInt("upload_mz_scs_fail"),
                    rs.getInt("upload_mz_scs_no"),
                    rs.getInt("upload_zy_cds_succ"),
                    rs.getInt("upload_zy_cds_fail"),
                    rs.getInt("upload_zy_cds_no"),
                    rs.getInt("upload_zy_scs_succ"),
                    rs.getInt("upload_zy_scs_fail"),
                    rs.getInt("upload_zy_scs_no"));
        }
        drgsDataTool.close(rs);
        drgsDataTool.close(ps);
        sql = "select decode(sum(case when s.type_code ='2' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%') then 1 else 0 end)+sum(case when s.med_type ='14' and s.type_code ='1' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%') then 1 else 0 end),'',0,sum(case when s.type_code ='2' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%') then 1 else 0 end)+sum(case when s.med_type ='14' and s.type_code ='1' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%') then 1 else 0 end)) his_all, decode(sum(case when s.med_type ='14' and s.type_code ='1' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%' ) then 1 else 0 end),'',0,sum(case when s.med_type ='14' and s.type_code ='1' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%' ) then 1 else 0 end)) his_mz_all, decode(sum(case when s.med_type ='14' and s.type_code ='1' and s.insuplc_admdvs like '5101%' then 1 else 0 end),'',0,sum(case when s.med_type ='14' and s.type_code ='1' and s.insuplc_admdvs like '5101%' then 1 else 0 end)) his_mz_cds, decode(sum(case when s.med_type ='14' and s.type_code ='1' and s.insuplc_admdvs like '5199%' then 1 else 0 end),'',0,sum(case when s.med_type ='14' and s.type_code ='1' and s.insuplc_admdvs like '5199%' then 1 else 0 end)) his_mz_scs, decode(sum(case when s.type_code ='2' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%' ) then 1 else 0 end),'',0,sum(case when s.type_code ='2' and (s.insuplc_admdvs like '5101%' or s.insuplc_admdvs like '5199%' ) then 1 else 0 end)) his_zy_all, decode(sum(case when s.type_code ='2' and s.insuplc_admdvs like '5101%' then 1 else 0 end),'',0,sum(case when s.type_code ='2' and s.insuplc_admdvs like '5101%' then 1 else 0 end)) his_zy_cds, decode(sum(case when s.type_code ='2' and s.insuplc_admdvs like '5199%' then 1 else 0 end),'',0,sum(case when s.type_code ='2' and s.insuplc_admdvs like '5199%' then 1 else 0 end)) his_zy_scs from si_chs_setl_info@his50 s where  s.valid_flag = '1' and s.setl_time >='" + beginDate + " 00:00:00' and s.setl_time <='" + endDate + " 23:59:59'";
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()){
            baoBiao4101ABean.setHisAll(rs1.getInt("his_all"));
            baoBiao4101ABean.setHisMzAll(rs1.getInt("his_mz_all"));
            baoBiao4101ABean.setHisMzCds(rs1.getInt("his_mz_cds"));
            baoBiao4101ABean.setHisMzScs(rs1.getInt("his_mz_scs"));
            baoBiao4101ABean.setHisZyAll(rs1.getInt("his_zy_all"));
            baoBiao4101ABean.setHisZyCds(rs1.getInt("his_zy_cds"));
            baoBiao4101ABean.setHisZyScs(rs1.getInt("his_zy_scs"));
        }
        drgsDataTool.close(rs1);
        drgsDataTool.close(ps1);
        drgsDataTool.myConnClose(conn);
        return baoBiao4101ABean;
    }
}
