package com.syy.chen.servlet;

import com.google.gson.Gson;
import com.syy.chen.bean.OutPutBean;
import com.syy.chen.bean.UserBean;
import com.syy.chen.config;
import com.syy.chen.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录Servlet
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        UserBean userBean = new UserBean();
        OutPutBean outPutBean = new OutPutBean();
        PrintWriter pw = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            userBean = userDao.getUser(user, pass);
        } catch (Exception e) {
            outPutBean.setMsg(e.getMessage());
            outPutBean.setState(com.syy.chen.config.FAIL_STATE);
            e.printStackTrace();
        }
        if (userBean.getUser_no() != null) {
            outPutBean.setMsg(com.syy.chen.config.SUCCESS_MSG);
            outPutBean.setState(com.syy.chen.config.SUCCESS_STATE);
            outPutBean.setData(userBean);
        }
        Gson json = new Gson();
        String backRes = json.toJson(outPutBean);
        pw.write(backRes);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
