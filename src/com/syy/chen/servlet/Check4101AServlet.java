package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.jsqd.Data4101ABean;
import com.syy.chen.dao.impl.GetData4101ADaoImpl;
import com.syy.chen.models.DrgsDataTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Check4101AServlet", value = "/Check4101AServlet")
public class Check4101AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String setlIdMain = request.getParameter("setlIdMain");
        String mzType = request.getParameter("mzType");
        Data4101ABean checkData4101ABean = null;
        OutPutBean outPutBean = new OutPutBean();
        GetData4101ADaoImpl setlInfo4101ADao = new GetData4101ADaoImpl();
        DrgsDataTool hisDataTool = new DrgsDataTool();
        Connection conn = hisDataTool.getConn();
        try {
            checkData4101ABean = setlInfo4101ADao.getData4101A(setlIdMain,mzType,conn,false);
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            outPutBean.setData(checkData4101ABean);
        } catch (Exception e) {
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg(com.syy.chen.config.FAIL_MSG);
            outPutBean.setData(checkData4101ABean);
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Gson gson = new Gson();
        String backRes = gson.toJson(outPutBean);
        PrintWriter pw = response.getWriter();
        pw.write(backRes);
        pw.flush();
        pw.close();
    }
}
