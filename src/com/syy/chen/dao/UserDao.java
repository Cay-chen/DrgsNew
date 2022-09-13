package com.syy.chen.dao;

import com.syy.chen.bean.UserBean;

public interface UserDao {
    //登录 查询是否用户在
   Boolean isExtUser( String user,String password) throws Exception;
   UserBean getUser(String user, String password) throws Exception;

}
