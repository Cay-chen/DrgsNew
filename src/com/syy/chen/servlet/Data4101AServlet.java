package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.WebTableDataBean;
import com.syy.chen.dao.impl.GetData4101ADaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Data4101AServlet", value = "/Data4101AServlet")
public class Data4101AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String limit = request.getParameter("limit");
        String page = request.getParameter("page");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String mzType = request.getParameter("mzType");
        String chsType = request.getParameter("chsType");
        String setlId = request.getParameter("setlId");
        String state = request.getParameter("state");
        OutPutBean outPutBean = new OutPutBean();
        WebTableDataBean webTableDataBean = new WebTableDataBean();
        GetData4101ADaoImpl setlInfo4401ADao = new GetData4101ADaoImpl();
        try {
            webTableDataBean =setlInfo4401ADao.getSimpleData(limit,page,beginDate,endDate,mzType,chsType,setlId,state);
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            outPutBean.setData(webTableDataBean);
        } catch (Exception e) {
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg(com.syy.chen.config.FAIL_MSG);
            outPutBean.setData(webTableDataBean);
            e.printStackTrace();
        }
        Gson json = new Gson();
        String backRes = json.toJson(outPutBean);
        PrintWriter pw = response.getWriter();
        pw.write(backRes);
        pw.flush();
        pw.close();
    }
}
