package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.jsqd.BaoBiao4101ABean;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.zysy.BaoBiao4401Bean;
import com.syy.chen.dao.impl.BaoBiao4401DaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BaoBiao4401Servlet", value = "/BaoBiao4401Servlet")
public class BaoBiao4401Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        BaoBiao4401Bean baoBiao4101ABean = null;
        OutPutBean outPutBean = new OutPutBean();
        BaoBiao4401DaoImpl baoBiaoData = new BaoBiao4401DaoImpl();
        try {
            baoBiao4101ABean = baoBiaoData.getBaoBiaoData(beginDate, endDate);
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            outPutBean.setData(baoBiao4101ABean);
        } catch (Exception e) {
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg(com.syy.chen.config.FAIL_MSG);
            outPutBean.setData(baoBiao4101ABean);
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String backRes = gson.toJson(outPutBean);
        PrintWriter pw = response.getWriter();
        pw.write(backRes);
        pw.flush();
        pw.close();
    }


}
