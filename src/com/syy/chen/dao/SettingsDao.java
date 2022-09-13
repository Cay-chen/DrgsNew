package com.syy.chen.dao;

import com.syy.chen.bean.SettingBean;

public interface SettingsDao {
    SettingBean getData() throws Exception;
    int setData(String	grabAutoQd, int	grabDayQd	, int	grabTimeQd	, String	uploadAutoQd	, int	uploadDayQd	, int	uploadTimeQd	, String	grabAutoSy	, int	grabDaySy	, int	grabTimeSy	, String	uploadAutoSy	, int	uploadDaySy	, int uploadTimeSy) throws Exception;
}
