package com.syy.chen.dao.impl;

import com.syy.chen.dao.OperateDataDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperateDataDaoImpl implements OperateDataDao {
    @Override
    public void InsertUploadMsg(Connection conn, String inputJson, String setlIdMain, String setlId, String SetlDate, String outJson, String info, String uploadDate, String chsType, int upType, int state, String uploadMsg) throws Exception {
        String sql = null;
        if (info.equals("4101A")) {
            sql = "declare b_clob CLOB :=?; begin INSERT INTO LOGS_4101A_UPLOAD (SETL_ID_MAIN, SETL_ID,SELTL_DATE,INPUT_JSON,OUTPUT_JSON,INFO,UPLOAD_DATE,CHS_TYPE,UP_TYPE,STATE,UPLOAD_MSG) VALUES ( ?,?,to_date(?, 'yyyy-MM-dd HH24:mi:ss'),b_clob,?,?,to_date(?, 'yyyy-MM-dd HH24:mi:ss'),?,?,?,?); COMMIT; end;";
        } else if (info.equals("4401")) {
            sql = "declare b_clob CLOB :=?; begin INSERT INTO LOGS_4401_UPLOAD (SETL_ID_MAIN, SETL_ID,SELTL_DATE,INPUT_JSON,OUTPUT_JSON,INFO,UPLOAD_DATE,CHS_TYPE,UP_TYPE,STATE,UPLOAD_MSG) VALUES ( ?,?,to_date(?, 'yyyy-MM-dd HH24:mi:ss'),b_clob,?,?,to_date(?, 'yyyy-MM-dd HH24:mi:ss'),?,?,?,?); COMMIT; end;";
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, inputJson);
        ps.setString(2, setlIdMain);
        ps.setString(3, setlId);
        ps.setString(4, SetlDate);
        ps.setString(5, outJson);
        ps.setString(6, info);
        ps.setString(7, uploadDate);
        ps.setString(8, chsType);
        ps.setInt(9, upType);
        ps.setInt(10, state);
        if (uploadMsg == null) {
            uploadMsg = "";
        }
        ps.setString(11, uploadMsg);
        int result = ps.executeUpdate();
        ps.close();
    }

    @Override
    public void GrabDataErrMsg(Connection conn, String setlIdMain, String typeFlag, String typeMz, String errMsg, String errSql, String setlDate, String grabTime) {
        String sql;
            sql = "INSERT INTO ERROR_GRAPE_4101A (setl_id_main, type_flag,type_mz,err_msg,err_sql,setl_date,grape_time) VALUES ( ?,?,?,?,?,to_date(?, 'yyyy-MM-dd'),to_date(?, 'yyyy-MM-dd HH24:mi:ss'))";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, setlIdMain);
            ps.setString(2, typeFlag);
            ps.setString(3, typeMz);
            ps.setString(4, errMsg);
            ps.setString(5, errSql);
            ps.setString(6, setlDate);
            ps.setString(7, grabTime);
            ps.executeUpdate();
            ps.close();
            System.out.println("错误信息"+typeFlag+":"+setlIdMain);
        } catch (SQLException throwables) {
            try {
                assert ps != null;
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    @Override
    public void UpdateUploadState(Connection conn, String tradeSerial, int uploadState, String uploadTime, String setlIdMain, int mtType, String info) throws Exception {
        String sql;
        if (info.equals("4101A")) {
            if (mtType == 1) {
                sql = "update DATA_4101A_SETLINFO t set t.setl_list_id_cds =?,t.upload_state_cds =?,t.upload_time_cds  =to_date(?, 'yyyy-MM-dd  HH24:mi:ss') where t.setl_id_main =?";
            } else {
                sql = "update DATA_4101A_SETLINFO t set t.setl_list_id_scs =?,t.upload_state_scs =?,t.upload_time_scs  =to_date(?, 'yyyy-MM-dd  HH24:mi:ss') where t.setl_id_main =?";
            }
        } else {
            if (mtType == 1) {
                sql = "update DATA_4401_BASEINFO t set t.TRADE_SERIAL_CDS =?,t.upload_state_cds =?,t.upload_time_cds  =to_date(?, 'yyyy-MM-dd  HH24:mi:ss') where t.inpatient_no =?";
            } else {
                sql = "update DATA_4401_BASEINFO t set t.TRADE_SERIAL_SCS =?,t.upload_state_scs =?,t.upload_time_scs  =to_date(?, 'yyyy-MM-dd  HH24:mi:ss') where t.inpatient_no =?";
            }
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tradeSerial);
        ps.setInt(2, uploadState);
        ps.setString(3, uploadTime);
        ps.setString(4, setlIdMain);
        ps.executeUpdate();
        ps.close();
    }
}
