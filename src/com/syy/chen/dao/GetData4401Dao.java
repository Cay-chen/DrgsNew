package com.syy.chen.dao;

import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.bean.zysy.Data4401Bean;

import java.sql.Connection;

public interface GetData4401Dao {
    WebTableDataBean getSimpleData(String limit, String page, String beginDate, String endDate, String chsType, String setlId, String state)throws Exception;
    Data4401Bean getBaseInfo4401 (String inpatient_no, Connection conn, boolean isUpload) throws Exception;

}
