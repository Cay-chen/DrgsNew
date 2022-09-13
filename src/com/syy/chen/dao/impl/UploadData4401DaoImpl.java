package com.syy.chen.dao.impl;

import com.google.gson.Gson;
import com.syy.chen.Utils;
import com.syy.chen.YinHaiUtil;
import com.syy.chen.bean.yinhai.BackResult4101ABean;
import com.syy.chen.bean.zysy.BaseInfoBean;
import com.syy.chen.bean.zysy.Data4401Bean;
import com.syy.chen.dao.UploadData4401Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UploadData4401DaoImpl implements UploadData4401Dao {
    ArrayList<BaseInfoBean> getDateData(String date, int mtType, int state, Connection conn) throws Exception {
        String sql = null;
        ArrayList<BaseInfoBean> data = new ArrayList<>();
        switch (mtType) {
            case 0:
                switch (state) {
                    case 0:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                        break;
                    case -1:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                        break;
                    case -2:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                        break;
                }
                break;
            case 1:
                switch (state) {
                    case 0:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.TYPE_FLAG ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                        break;
                    case -1:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.TYPE_FLAG ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                        break;
                    case -2:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.TYPE_FLAG ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                        break;
                }
                break;
            case 2:
                switch (state) {
                    case 0:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.TYPE_FLAG ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                        break;
                    case -1:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.TYPE_FLAG ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                        break;
                    case -2:
                        sql = "select vu.setl_id_main ,vu.type_flag,vu.insuplc_admdvs from V_UPLOAD_4401_ALL vu where vu.TYPE_FLAG ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                        break;
                }
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            BaseInfoBean setlInfo4101ABean = new BaseInfoBean(rs.getString("setl_id_main"), rs.getString("type_flag"), rs.getString("insuplc_admdvs"));
            data.add(setlInfo4101ABean);
        }
        return data;
    }

    @Override
    public void uploadDataDate(String date, int mtType, String state, Connection conn) throws Exception {
        ArrayList<BaseInfoBean> arrayDataList;
        GetData4401DaoImpl data4101ADao = new GetData4401DaoImpl();
        arrayDataList = getDateData(date, mtType, Integer.parseInt(state), conn);
        assert arrayDataList != null;
        YinHaiDaoImpl yinHaiDao = new YinHaiDaoImpl();
        String signNo = yinHaiDao.getSingNo(mtType);
        for (BaseInfoBean setlInfo4101ABean : arrayDataList) {
            String setlIdMain = setlInfo4101ABean.getInpatient_no();
            Data4401Bean data = data4101ADao.getBaseInfo4401(setlIdMain, conn, true);
            String result = yinHaiDao.upLoad(data, "4401", signNo, setlInfo4101ABean.getInsuplc_admdvs(), Integer.parseInt(setlInfo4101ABean.getType_flag()));
            String backResult = YinHaiUtil.Api(result, Integer.parseInt(setlInfo4101ABean.getType_flag()));
            OperateDataDaoImpl o = new OperateDataDaoImpl();
            Gson gson = new Gson();
            BackResult4101ABean backData = gson.fromJson(backResult, BackResult4101ABean.class);
            o.InsertUploadMsg(conn, result, setlIdMain, setlIdMain, date, backResult, "4401", Utils.GetNowTime(), setlInfo4101ABean.getInsuplc_admdvs(), Integer.parseInt(setlInfo4101ABean.getType_flag()), backData.getInfcode(), backData.getErr_msg());
            if (backData.getInfcode() == 0) {
                o.UpdateUploadState(conn, backData.getOutput().getSetl_list_id(), backData.getInfcode(), Utils.GetNowTime(), setlIdMain, Integer.parseInt(setlInfo4101ABean.getType_flag()), "4401");
            } else {
                o.UpdateUploadState(conn, null, backData.getInfcode(), Utils.GetNowTime(), setlIdMain, Integer.parseInt(setlInfo4101ABean.getType_flag()), "4401");
            }
        }
        arrayDataList.clear();
    }

    @Override
    public String uploadData(String setlIdMain1, String insuplcAdmdvs, int mtType, String date, Connection conn) throws Exception {
        YinHaiDaoImpl yinHaiDao = new YinHaiDaoImpl();
        String signNo = yinHaiDao.getSingNo(mtType);
        GetData4401DaoImpl data4101ADao = new GetData4401DaoImpl();
        Data4401Bean data = data4101ADao.getBaseInfo4401(setlIdMain1, conn, true);
        String result = yinHaiDao.upLoad(data, "4401", signNo, insuplcAdmdvs, mtType);
        String backResult = YinHaiUtil.Api(result, mtType);
        OperateDataDaoImpl o = new OperateDataDaoImpl();
        Gson gson = new Gson();
        BackResult4101ABean backData = gson.fromJson(backResult, BackResult4101ABean.class);
        o.InsertUploadMsg(conn, result, setlIdMain1, setlIdMain1, date, backResult, "4401", Utils.GetNowTime(), insuplcAdmdvs, mtType, backData.getInfcode(), backData.getErr_msg());
        if (backData.getInfcode() == 0) {
            o.UpdateUploadState(conn, backData.getOutput().getSetl_list_id(), backData.getInfcode(), Utils.GetNowTime(), setlIdMain1, mtType, "4401");
        } else {
            o.UpdateUploadState(conn, null, backData.getInfcode(), Utils.GetNowTime(), setlIdMain1, mtType, "4401");
        }
        return backResult;

    }
}
