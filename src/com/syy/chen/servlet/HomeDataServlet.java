package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.dao.impl.HomeDataDaoImpl;
import com.syy.chen.dao.impl.SettingsDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeDataServlet", value = "/HomeDataServlet")
public class HomeDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        int num = Integer.parseInt(request.getParameter("num"));
        HomeDataDaoImpl homeDataDao = new HomeDataDaoImpl();
        SettingsDaoImpl  settingsDao = new SettingsDaoImpl();
        OutPutBean outPutBean = new OutPutBean();
        try {
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            outPutBean.setData(homeDataDao.getData(settingsDao.getData().getGrabDayQd()));
        } catch (Exception e) {
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg(e.getMessage());
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String back =gson.toJson(outPutBean);
        PrintWriter pw = response.getWriter();
        pw.write(back);
        pw.flush();
        pw.close();
    }
}
