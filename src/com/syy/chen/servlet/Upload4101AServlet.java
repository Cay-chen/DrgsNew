package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.Utils;
import com.syy.chen.YinHaiUtil;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.jsqd.Data4101ABean;
import com.syy.chen.bean.jsqd.SetlInfo4101ABean;
import com.syy.chen.bean.yinhai.BackResult4101ABean;
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

/**
 * 上传到银海Servlet
 */
@WebServlet(name = "Upload4101AServlet", value = "/Upload4101AServlet")
public class Upload4101AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String mzType = request.getParameter("mzType");
        int mtType = Integer.parseInt(request.getParameter("mtType"));
        String date = request.getParameter("date");
        String state = request.getParameter("state");
        String setlIdMain1 = request.getParameter("setlIdMain");
        String insuplcAdmdvs = request.getParameter("insuplcAdmdvs");
        OutPutBean outPutBean = new OutPutBean();
        DrgsDataTool dataTool = new DrgsDataTool();
        Connection conn = dataTool.getConn();
        if (setlIdMain1 == null|| setlIdMain1.equals("")) {
            UploadData4101ADaoImpl uploadData4101ADao;
            uploadData4101ADao = new UploadData4101ADaoImpl();
            if (mtType == 0) {
                try {
                    uploadData4101ADao.uploadDataDate(date, mzType,1, state, conn);
                    uploadData4101ADao.uploadDataDate(date,mzType, 2, state, conn);
                    outPutBean.setMsg("数据上传完成！");
                    outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                } catch (Exception e) {
                    outPutBean.setMsg("内部错误！ " + e.getMessage());
                    outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                    e.printStackTrace();
                }
            }else {
                try {
                    uploadData4101ADao.uploadDataDate(date, mzType,mtType, state, conn);
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
                UploadData4101ADaoImpl uploadData4101ADao = new UploadData4101ADaoImpl();
                String backResult =uploadData4101ADao.uploadData(setlIdMain1,insuplcAdmdvs,mzType,mtType,date,conn);
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

