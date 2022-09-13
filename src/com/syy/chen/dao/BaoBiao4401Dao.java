package com.syy.chen.dao;

import com.syy.chen.bean.zysy.BaoBiao4401Bean;

public interface BaoBiao4401Dao {
    BaoBiao4401Bean getBaoBiaoData(String beginDate, String endDate) throws Exception;
}
