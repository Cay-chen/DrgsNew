package com.syy.chen.dao.impl;

import com.syy.chen.bean.SettingBean;
import com.syy.chen.dao.SettingsDao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SettingsDaoImpl implements SettingsDao {
    @Override
    public SettingBean getData() throws Exception {
        String sql ="SELECT * FROM SYSTEM_SETTINGS WHERE ID =1 ";
        SettingBean settingsDao = null;
        DrgsDataTool dataTool = new DrgsDataTool();
        Connection conn =dataTool.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
             settingsDao = new SettingBean(
                    rs.getString(1),
                    rs.getInt(3),
                    rs.getInt(2),
                    rs.getString(4),
                    rs.getInt(6),
                    rs.getInt(5),
                    rs.getString(7),
                    rs.getInt(9),
                    rs.getInt(8),
                    rs.getString(10),
                    rs.getInt(12),
                    rs.getInt(11)
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return settingsDao;
    }

    @Override
    public int setData(String grabAutoQd, int grabDayQd, int grabTimeQd, String uploadAutoQd, int uploadDayQd, int uploadTimeQd, String grabAutoSy, int grabDaySy, int grabTimeSy, String uploadAutoSy, int uploadDaySy, int uploadTimeSy) throws Exception {
       // String sql = "INSERT INTO SYSTEM_SETTINGS ( IS_AUTO_GRAB_4101A,AUTO_TIME_GRAB_4101A,BEFORE_DAY_GRAB_4101A,IS_AUTO_UPLOAD_4101A,AUTO_TIME_UPLOAD_4101A,BEFORE_DAY_UPLOAD_4101A,IS_AUTO_GRAB_4401,AUTO_TIME_GRAB_4401,BEFORE_DAY_GRAB_4401,IS_AUTO_UPLOAD_4401,AUTO_TIME_UPLOAD_4401,BEFORE_DAY_UPLOAD_4401,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql ="UPDATE SYSTEM_SETTINGS s SET s.IS_AUTO_GRAB_4101A=?,s.AUTO_TIME_GRAB_4101A=? ,s.BEFORE_DAY_GRAB_4101A=?,s.IS_AUTO_UPLOAD_4101A=?,s.AUTO_TIME_UPLOAD_4101A=?,s.BEFORE_DAY_UPLOAD_4101A=?,s.IS_AUTO_GRAB_4401=?,s.AUTO_TIME_GRAB_4401=?,s.BEFORE_DAY_GRAB_4401=?,s.IS_AUTO_UPLOAD_4401=?,s.AUTO_TIME_UPLOAD_4401=?,s.BEFORE_DAY_UPLOAD_4401=? WHERE s.ID=1";
        DrgsDataTool dataTool = new DrgsDataTool();
        Connection conn =dataTool.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,grabAutoQd);
        ps.setInt(3,grabDayQd);
        ps.setInt(2,grabTimeQd);
        ps.setString(4,uploadAutoQd);
        ps.setInt(6,uploadDayQd);
        ps.setInt(5,uploadTimeQd);
        ps.setString(7,grabAutoSy);
        ps.setInt(9,grabDaySy);
        ps.setInt(8,grabTimeSy);
        ps.setString(10,uploadAutoSy);
        ps.setInt(12,uploadDaySy);
        ps.setInt(11,uploadTimeSy);
        int backResult =ps.executeUpdate();
        //ps.setInt(13,1);
        ps.close();
        conn.close();
        return backResult;
    }
}
