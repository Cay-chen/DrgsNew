package com.syy.chen.dao;

import java.sql.Connection;

public interface UploadData4401Dao {
/*
    ArrayList<BaseInfoBean> getDateData(String date, int mtType, int state, Connection con) throws Exception;
*/
    void uploadDataDate(String date,int mtType ,String state,Connection conn) throws Exception;
    String uploadData(String setlIdMain1, String insuplcAdmdvs, int mtType, String date, Connection conn) throws Exception;

}
