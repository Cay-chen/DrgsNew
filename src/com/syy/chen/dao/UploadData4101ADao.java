package com.syy.chen.dao;

import java.sql.Connection;

public interface UploadData4101ADao {
/*
    ArrayList<SetlInfo4101ABean> getDateData(String date, String mzType, int mtType,int state, Connection con) throws Exception;
*/

    void uploadDataDate(String date,String mzType,int mtType ,String state,Connection conn) throws Exception;
    String uploadData(String setlIdMain1, String insuplcAdmdvs, String mzType, int mtType, String date, Connection conn) throws Exception;
}
