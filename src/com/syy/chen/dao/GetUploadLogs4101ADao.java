package com.syy.chen.dao;

import com.syy.chen.bean.WebTableDataBean;

import java.sql.Connection;

public interface GetUploadLogs4101ADao {
    WebTableDataBean get4101AUploadLogs(Connection conn , String setlIdMain) throws Exception;
}
