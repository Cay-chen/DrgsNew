package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.SettingBean;
import com.syy.chen.dao.impl.SettingsDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SettingsServlet", value = "/SettingsServlet")
public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String method = request.getParameter("method");
        String grabAutoQd = request.getParameter("grabAutoQd");
        String grabDayQd = request.getParameter("grabDayQd");
        String grabTimeQd = request.getParameter("grabTimeQd");
        String uploadAutoQd = request.getParameter("uploadAutoQd");
        String uploadDayQd = request.getParameter("uploadDayQd");
        String uploadTimeQd = request.getParameter("uploadTimeQd");
        String grabAutoSy = request.getParameter("grabAutoSy");
        String grabDaySy = request.getParameter("grabDaySy");
        String grabTimeSy = request.getParameter("grabTimeSy");
        String uploadAutoSy = request.getParameter("uploadAutoSy");
        String uploadDaySy = request.getParameter("uploadDaySy");
        String uploadTimeSy = request.getParameter("uploadTimeSy");
        OutPutBean outPutBean = new OutPutBean();
        SettingsDaoImpl settings = new SettingsDaoImpl();
        try {
            if (method==null) {
                SettingBean settingBean = settings.getData();
                outPutBean.setData(settingBean);
                outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            } else {
                if (method.equals("set")) {
                    int num = settings.setData(grabAutoQd, Integer.parseInt(grabDayQd), Integer.parseInt(grabTimeQd), uploadAutoQd, Integer.parseInt(uploadDayQd), Integer.parseInt(uploadTimeQd), grabAutoSy, Integer.parseInt(grabDaySy), Integer.parseInt(grabTimeSy), uploadAutoSy, Integer.parseInt(uploadDaySy), Integer.parseInt(uploadTimeSy));
                    if (num > 0) {
                        outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                        outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
                    } else {
                        outPutBean.setState(com.syy.chen.config.FAIL_STATE);
                        outPutBean.setMsg("保存失败！");
                    }
                } else {
                    SettingBean settingBean = settings.getData();
                    outPutBean.setData(settingBean);
                    outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
                    outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
                }
            }
        } catch (Exception e) {
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            outPutBean.setMsg("保存失败！:" + e.getMessage());
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
