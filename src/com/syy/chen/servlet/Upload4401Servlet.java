package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.Utils;
import com.syy.chen.YinHaiUtil;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.jsqd.Data4101ABean;
import com.syy.chen.bean.jsqd.SetlInfo4101ABean;
import com.syy.chen.bean.yinhai.BackResult4101ABean;
import com.syy.chen.bean.zysy.BaseInfoBean;
import com.syy.chen.bean.zysy.Data4401Bean;
import com.syy.chen.config;
import com.syy.chen.dao.impl.*;
import com.syy.chen.models.DrgsDataTool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Upload4401Servlet", value = "/Upload4401Servlet")
public class Upload4401Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        int mtType = Integer.parseInt(request.getParameter("mtType"));
        String date = request.getParameter("date");
        String state = request.getParameter("state");
        String setlIdMain1 = request.getParameter("setlIdMain");
        String insuplcAdmdvs = request.getParameter("insuplcAdmdvs");
        OutPutBean outPutBean = new OutPutBean();
        DrgsDataTool dataTool = new DrgsDataTool();
        Connection conn = dataTool.getConn();
        if (setlIdMain1 == null || setlIdMain1.equals("")) {
            UploadData4401DaoImpl uploadData4401Dao;
            uploadData4401Dao = new UploadData4401DaoImpl();
            if (mtType == 0) {
                try {
                    uploadData4401Dao.uploadDataDate(date, 1, state, conn);
                    uploadData4401Dao.uploadDataDate(date, 2, state, conn);
                    outPutBean.setMsg("数据上传完成！");
                    outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                } catch (Exception e) {
                    outPutBean.setMsg("内部错误！ " + e.getMessage());
                    outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                    e.printStackTrace();
                }
            }else {
                try {
                    uploadData4401Dao.uploadDataDate(date, mtType, state, conn);
                    outPutBean.setMsg(date+"数据上传完成！");
                    outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                } catch (Exception e) {
                    outPutBean.setMsg("内部错误！ " + e.getMessage());
                    outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                    e.printStackTrace();
                }
            }
        } else {
            try {
                UploadData4401DaoImpl uploadData4401Dao = new UploadData4401DaoImpl();
                String backResult =uploadData4401Dao.uploadData(setlIdMain1,insuplcAdmdvs,mtType,date,conn);
                Gson gson = new Gson();
                BackResult4101ABean backData = gson.fromJson(backResult, BackResult4101ABean.class);
                if (backData.getInfcode()==0) {
                    outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
                    outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                }else {
                    outPutBean.setMsg(backData.getErr_msg());
                    outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                }
            } catch (Exception e) {
                outPutBean.setMsg("内部错误！ "+e.getMessage());
                outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                e.printStackTrace();
            }
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();
        String result = gson.toJson(outPutBean);
        pw.write(result);
        pw.flush();
        pw.close();
    }
}
