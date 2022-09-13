package com.syy.chen.dao;

import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.bean.jsqd.Data4101ABean;

import java.sql.Connection;

public interface GetData4101ADao {
    WebTableDataBean getSimpleData (String limit, String page, String beginDate, String endDate, String mzType, String chsType, String setlId, String state) throws Exception;
    Data4101ABean getData4101A (String setlIdMain, String mzType,Connection conn, boolean isUpload) throws Exception;
}
