package com.syy.chen.models;

import com.syy.chen.FileProperties;

import java.sql.*;

public class DrgsDataTool {

	static String className = new String();
	static String url = new String();
	static String user = new String();
	static String password = new String();
	//private static Properties props = new Properties();
	//private static Connection connection = null;
	
	static{
		try {
			className=FileProperties.getConfig("DrgsClassName");
			//className = "oracle.jdbc.driver.OracleDriver";
			if (FileProperties.getConfig("evnV").equals("1")){
				url = FileProperties.getConfig("DrgsDbUrlS");
			}else {
				url = FileProperties.getConfig("DrgsDbUrlC");
			}
			//url = "jdbc:oracle:thin:@192.161.99.125:1521/grds";
			//url = "jdbc:oracle:thin:@192.192.192.102:1521/ybsb";
			user = FileProperties.getConfig("DrgsUser");
			password =FileProperties.getConfig("DrgsPassword");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public DrgsDataTool() {
    	try {
			Class.forName(className);
		} catch (Exception e) {
			System.out.println("加载数据库失败！");
			e.printStackTrace();
		}
    }
    
    public Connection getConn(){ 	
    	Connection conn =null;
    	try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("链接数据库失败！");
			e.printStackTrace();
		}
    	return conn;
    }
    
    public void myConnClose(Connection conn){
    
    	try {
    		if(conn!=null){
    			conn.close();
    		//	System.out.println("数据库关闭成功！");
    			conn = null;
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void close(Statement stm){
		try {
			if(stm != null){
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
