package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.dao.impl.GetUploadLogs4401DaoImpl;
import com.syy.chen.models.DrgsDataTool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetLogs4401Servlet", value = "/GetLogs4401Servlet")
public class GetLogs4401Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String setlIdMain = request.getParameter("setlIdMain");
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection connection = drgsDataTool.getConn();
        OutPutBean outPutBean = new OutPutBean();
        GetUploadLogs4401DaoImpl getUploadLogsDao = new GetUploadLogs4401DaoImpl();
        try {
            WebTableDataBean w = getUploadLogsDao.get4101AUploadLogs(connection, setlIdMain);
            connection.close();
            outPutBean.setData(w);
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
        } catch (Exception e) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg(com.syy.chen.config.FAIL_MSG);
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String backResult = gson.toJson(outPutBean);
        PrintWriter pw = response.getWriter();
        pw.write(backResult);
        pw.flush();
        pw.close();
    }
}
