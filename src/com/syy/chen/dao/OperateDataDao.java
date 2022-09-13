package com.syy.chen.dao;

import java.sql.Connection;

public interface OperateDataDao {
    void InsertUploadMsg(Connection conn, String inputJson, String setlIdMain, String setlId, String SetlDate, String outJson, String info, String uploadDate, String chsType, int upType,int state,String uploadMsg) throws Exception;
    void GrabDataErrMsg(Connection conn,String setlIdMain, String typeFlag, String typeMz, String errMsg, String errSql, String setlDate ,String grabTime) throws Exception;
    void UpdateUploadState(Connection conn, String tradeSerial, int uploadState, String uploadTime, String setlIdMain, int mtType,String info) throws Exception;

}
