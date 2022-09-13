package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.jsqd.Data4101ABean;
import com.syy.chen.bean.zysy.Data4401Bean;
import com.syy.chen.dao.impl.GetData4101ADaoImpl;
import com.syy.chen.dao.impl.GetData4401DaoImpl;
import com.syy.chen.models.DrgsDataTool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Check4401Servlet", value = "/Check4401Servlet")
public class Check4401Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String inpatient_no = request.getParameter("inpatient_no");
        Data4401Bean checkData4101ABean = null;
        OutPutBean outPutBean = new OutPutBean();
        GetData4401DaoImpl setlInfo4101ADao = new GetData4401DaoImpl();
        DrgsDataTool hisDataTool = new DrgsDataTool();
        Connection conn = hisDataTool.getConn();
        try {
            checkData4101ABean = setlInfo4101ADao.getBaseInfo4401(inpatient_no,conn,false);
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
