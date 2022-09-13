package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.dao.impl.GrabData4101ADaoImpl;
import com.syy.chen.models.BaglDataTool;
import com.syy.chen.models.DrgsDataTool;
import com.syy.chen.models.HisDataTool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GrabData4101AServlet", value = "/GrabData4101AServlet")
public class GrabData4101AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String dataName = request.getParameter("dataName");
        String dataDate = request.getParameter("dataDate");
        int typeCode = Integer.parseInt(request.getParameter("typeCode")); // 0全抓  1 setl 2dise 3oprn 4icu 5 bld 6 opsp
        GrabData4101ADaoImpl getBaglDataDao = new GrabData4101ADaoImpl();
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection conn = drgsDataTool.getConn();
        BaglDataTool baglDataTool = new BaglDataTool();
        Connection connBa = baglDataTool.getConn();
        HisDataTool hisDataTool = new HisDataTool();
        Connection connHis = hisDataTool.getConn();
        OutPutBean outPutBean = new OutPutBean();
        try {
            switch (dataName) {
                case "1":
                    getBaglDataDao.getHisMzSetlInfo(dataDate, conn, connHis);
                    break;
                case "2":
                    getBaglDataDao.getHisZySetlInfoList(dataDate, typeCode, conn, connBa);
                    break;
                case "0":
                    if (typeCode == 0) {
                        getBaglDataDao.getHisMzSetlInfo(dataDate, conn, connHis);
                    }
                    getBaglDataDao.getHisZySetlInfoList(dataDate, typeCode, conn, connBa);
                    break;
            }
            conn.close();
            connBa.close();
            connHis.close();
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setMsg(dataDate+"数据抓取完成！");
        } catch (Exception e) {
            try {
                conn.close();
                connBa.close();
                connHis.close();
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
