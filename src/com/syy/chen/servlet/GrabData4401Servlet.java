package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.dao.impl.GrabData4101ADaoImpl;
import com.syy.chen.dao.impl.GrabData4401DaoImpl;
import com.syy.chen.models.BaglDataTool;
import com.syy.chen.models.DrgsDataTool;
import com.syy.chen.models.HisDataTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GrabData4401AServlet", value = "/GrabData4401Servlet")
public class GrabData4401Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String dataDate = request.getParameter("dataDate");
        GrabData4401DaoImpl getBaglDataDao = new GrabData4401DaoImpl();
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection conn = drgsDataTool.getConn();
        BaglDataTool baglDataTool = new BaglDataTool();
        Connection connBa = baglDataTool.getConn();
        OutPutBean outPutBean = new OutPutBean();
        int back = -1;
        try {
            back = getBaglDataDao.getData(dataDate, conn, connBa);
            conn.close();
            connBa.close();
            if (back != -1) {
                outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            } else {
                outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                outPutBean.setMsg(com.syy.chen.config.FAIL_MSG);
            }
        } catch (
                Exception e) {
            try {
                conn.close();
                connBa.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg(e.getMessage());
            e.printStackTrace();
        }

        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();
        String backString = gson.toJson(outPutBean);
        pw.write(backString);
        pw.flush();
        pw.close();
    }
}
