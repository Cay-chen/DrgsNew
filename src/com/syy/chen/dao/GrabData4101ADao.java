package com.syy.chen.dao;

import java.sql.Connection;

public interface GrabData4101ADao {
        void getHisZySetlInfoList(String date ,int typeCode,Connection connection,Connection bagl) throws Exception;
        void getBaglSetlInfo(String inpatientNo, Connection conn, Connection bagl,String setlIdMain, String psnNo, String setlID, String mdtrtId,String mzType ,String typeFlag ,String insuplcAdmdvs ,String pactCode ,String medicalType ,String grapTime ,String transType ,String setlDate,String setlTime,String  invoiceNo,String inDate, String outDate) throws Exception;
        void getBaglDiseInfo(String inpatientNo,String setlIdMain, Connection conn, Connection bagl ) throws Exception;
        void getBaglOprnInfo(String inpatientNo,String setlIdMain, Connection conn, Connection bagl ) throws Exception;
        void getBaglBldInfo(String inpatientNo,String setlIdMain, Connection conn, Connection bagl ) throws Exception;
        void getIcuInfo(String inpatientNo,String setlIdMain, Connection conn ) throws Exception;
        void getHisOpspDiseInfo(String inpatientNo,String setlIdMain, Connection conn,Connection con,String mId) throws Exception;
        void getHisMzSetlInfo(String date,Connection conn, Connection connection) throws Exception;


}
