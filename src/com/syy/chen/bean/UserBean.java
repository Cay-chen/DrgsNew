package com.syy.chen.bean;

public class UserBean {
    private String user_no;
    private String user_name;
    private String user_passwo;
    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_passwo() {
        return user_passwo;
    }

    public void setUser_passwo(String user_passwo) {
        this.user_passwo = user_passwo;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "user_no='" + user_no + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_passwo='" + user_passwo + '\'' +
                '}';
    }
}
