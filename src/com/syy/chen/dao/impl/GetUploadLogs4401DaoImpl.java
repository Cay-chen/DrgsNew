package com.syy.chen.dao.impl;

import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.bean.jsqd.Jl4101ABean;
import com.syy.chen.dao.GetUploadLogs4401Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetUploadLogs4401DaoImpl implements GetUploadLogs4401Dao {
    @Override
    public WebTableDataBean get4101AUploadLogs(Connection conn, String setlIdMain) throws Exception {
        ArrayList<Jl4101ABean> jl4101ABeans = new ArrayList<>();
        String sql ="select * from LOGS_4401_UPLOAD l where l.SETL_ID_MAIN=? order by l.UPLOAD_DATE desc";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,setlIdMain);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Jl4101ABean jl4101ABean = new Jl4101ABean(rs.getString(1),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(7),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11)
                    );
            jl4101ABeans.add(jl4101ABean);
        }
        rs.close();
        ps.close();
        return new WebTableDataBean(0,jl4101ABeans,jl4101ABeans.size(),"成功");

    }
}
