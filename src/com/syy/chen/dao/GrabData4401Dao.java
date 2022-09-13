package com.syy.chen.dao;

import java.sql.Connection;

public interface GrabData4401Dao {
    int getData(String date, Connection con, Connection baglConn) throws Exception;
}
