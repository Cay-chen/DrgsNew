package com.syy.chen.dao;

import com.syy.chen.bean.jsqd.BaoBiao4101ABean;

public interface BaoBiao4101ADao {
    BaoBiao4101ABean getBaoBiaoData(String beginDate, String endDate) throws Exception;
}
