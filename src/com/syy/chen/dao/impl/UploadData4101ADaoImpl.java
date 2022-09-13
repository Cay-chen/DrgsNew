package com.syy.chen.dao.impl;

import com.google.gson.Gson;
import com.syy.chen.Utils;
import com.syy.chen.YinHaiUtil;
import com.syy.chen.bean.jsqd.Data4101ABean;
import com.syy.chen.bean.jsqd.SetlInfo4101ABean;
import com.syy.chen.bean.yinhai.BackResult4101ABean;
import com.syy.chen.dao.UploadData4101ADao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UploadData4101ADaoImpl implements UploadData4101ADao {
    ArrayList<SetlInfo4101ABean> getDateData(String date, String mzType, int mtType, int state, Connection conn) throws Exception {
        String sql = null;
        //HashMap<String, Integer> dataMap = new HashMap<>();
        ArrayList<SetlInfo4101ABean> data = new ArrayList<>();
        switch (mtType) {
            case 0:
                switch (mzType) {
                    case "0":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                    case "1":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') ";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }

                        break;
                    case "2":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                }
                break;
            case 1:
                switch (mzType) {
                    case "0":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                    case "1":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                    case "2":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='1' and vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                }
                break;
            case 2:
                switch (mzType) {
                    case "0":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                    case "1":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.TYPE_MZ='1' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                    case "2":
                        switch (state) {
                            case 0:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd')";
                                break;
                            case -1:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  (vu.UPLOAD_STATE_CDS='-1' or vu.UPLOAD_STATE_SCS='-1')";
                                break;
                            case -2:
                                sql = "select vu.setl_id_main ,vu.type_flag,vu.type_mz,vu.insuplc_admdvs from V_UPLOAD_4101A_ALL vu where vu.TYPE_FLAG ='2' and vu.TYPE_MZ='2' and vu.setl_date = to_date( '" + date + "','yyyy-mm-dd') and  vu.UPLOAD_STATE_CDS='-2' and vu.UPLOAD_STATE_SCS='-2'";
                                break;
                        }
                        break;
                }
                break;
        }


        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SetlInfo4101ABean setlInfo4101ABean = new SetlInfo4101ABean(rs.getString("setl_id_main"), rs.getString("type_flag"), rs.getString("type_mz"), rs.getString("insuplc_admdvs"));
            data.add(setlInfo4101ABean);
        }
        return data;
    }

    @Override
    public void uploadDataDate(String date, String mzType, int mtType, String state, Connection conn) {
        ArrayList<SetlInfo4101ABean> arrayDataList = null;
        GetData4101ADaoImpl data4101ADao = new GetData4101ADaoImpl();
        try {
            arrayDataList = getDateData(date, mzType, mtType, Integer.parseInt(state), conn);
        } catch (Exception e) {
            System.out.println("ERROR1001:上传获取一天数据失败！"+e.getMessage());
            e.printStackTrace();
        }
        assert arrayDataList != null;
        YinHaiDaoImpl yinHaiDao = new YinHaiDaoImpl();
        String signNo = null;
        try {
            signNo = yinHaiDao.getSingNo(mtType);
        } catch (Exception e) {
            System.out.println("ERROR3001:银海签到失败！"+e.getMessage());
            e.printStackTrace();
        }
        for (SetlInfo4101ABean setlInfo4101ABean : arrayDataList) {
            String setlIdMain = setlInfo4101ABean.getSetl_id_main();
            Data4101ABean data;
            try {
                data = data4101ADao.getData4101A(setlIdMain, setlInfo4101ABean.getType_mz(), conn, true);
                String result = yinHaiDao.upLoad(data, "4101A", signNo, setlInfo4101ABean.getInsuplc_admdvs(), Integer.parseInt(setlInfo4101ABean.getType_flag()));
                String backResult = YinHaiUtil.Api(result, Integer.parseInt(setlInfo4101ABean.getType_flag()));
                OperateDataDaoImpl o = new OperateDataDaoImpl();
                Gson gson = new Gson();
                BackResult4101ABean backData = gson.fromJson(backResult, BackResult4101ABean.class);
                o.InsertUploadMsg(conn, result, setlIdMain, setlIdMain, date, backResult, "4101A", Utils.GetNowTime(), setlInfo4101ABean.getInsuplc_admdvs(), Integer.parseInt(setlInfo4101ABean.getType_flag()), backData.getInfcode(), backData.getErr_msg());
                if (backData.getInfcode() == 0) {
                    o.UpdateUploadState(conn, backData.getOutput().getSetl_list_id(), backData.getInfcode(), Utils.GetNowTime(), setlIdMain, Integer.parseInt(setlInfo4101ABean.getType_flag()), "4101A");
                } else {
                    o.UpdateUploadState(conn, null, backData.getInfcode(), Utils.GetNowTime(), setlIdMain, Integer.parseInt(setlInfo4101ABean.getType_flag()), "4101A");
                }
            } catch (Exception e) {
                System.out.println("ERROR2002:上传数据失败！"+e.getMessage());
                e.printStackTrace();
            }
        }
        arrayDataList.clear();

    }

    @Override
    public String uploadData(String setlIdMain1, String insuplcAdmdvs, String mzType, int mtType, String date, Connection conn) throws Exception {
        YinHaiDaoImpl yinHaiDao = new YinHaiDaoImpl();
        String signNo;
        signNo = yinHaiDao.getSingNo(mtType);
        GetData4101ADaoImpl data4101ADao = new GetData4101ADaoImpl();
        Data4101ABean data = data4101ADao.getData4101A(setlIdMain1, mzType, conn, true);
        String result = yinHaiDao.upLoad(data, "4101A", signNo, insuplcAdmdvs, mtType);
        String backResult = YinHaiUtil.Api(result, mtType);
        OperateDataDaoImpl o = new OperateDataDaoImpl();
        Gson gson = new Gson();
        BackResult4101ABean backData = gson.fromJson(backResult, BackResult4101ABean.class);
        o.InsertUploadMsg(conn, result, setlIdMain1, setlIdMain1, date, backResult, "4101A", Utils.GetNowTime(), insuplcAdmdvs, mtType, backData.getInfcode(), backData.getErr_msg());
        if (backData.getInfcode() == 0) {
            o.UpdateUploadState(conn, backData.getOutput().getSetl_list_id(), backData.getInfcode(), Utils.GetNowTime(), setlIdMain1, mtType, "4101A");
        } else {
            o.UpdateUploadState(conn, null, backData.getInfcode(), Utils.GetNowTime(), setlIdMain1, mtType, "4101A");
        }
        return backResult;
    }
}
