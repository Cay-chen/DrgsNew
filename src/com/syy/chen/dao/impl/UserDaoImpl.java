package com.syy.chen.dao.impl;

import com.syy.chen.bean.UserBean;
import com.syy.chen.dao.UserDao;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public Boolean isExtUser(String user, String password) throws Exception {
        boolean isExist = false;
        DrgsDataTool hisSql = new DrgsDataTool();
        Connection conn = hisSql.getConn();
        String sql = "select * from user_info where user_no='" + user + "' and user_password = '" + password + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            isExist = true;
        }
        hisSql.close(ps);
        hisSql.close(rs);
        hisSql.myConnClose(conn);
        return isExist;
    }

    @Override
    public UserBean getUser(String user, String password) throws Exception {
        UserBean userBean = new UserBean();
        DrgsDataTool DrgsSql = new DrgsDataTool();
        Connection conn = DrgsSql.getConn();
        String sql = "select * from user_info where user_no='" + user + "' and user_password = '" + password + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            userBean.setUser_no(rs.getString("user_no"));
            userBean.setUser_name(rs.getString("user_name"));
           // userBean.setUser_passwo(rs.getString("user_password"));
        }
        DrgsSql.close(ps);
        DrgsSql.close(rs);
        DrgsSql.myConnClose(conn);
        return userBean;
    }
}
