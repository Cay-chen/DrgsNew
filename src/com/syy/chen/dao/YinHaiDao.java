package com.syy.chen.dao;

public interface YinHaiDao {
    String getSingNo(int pt) throws Exception;
    String upLoad(Object input,String jyNo,String signNo,String insuplcAdmdvs,int pt) throws Exception;
}
