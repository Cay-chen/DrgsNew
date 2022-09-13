package com.syy.chen.models;

import java.sql.*;


public class MysqlTool {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//private static MysqlTool mysqlTool = new MysqlTool();
	static String className = new String();
	static String url = new String();
	static String user = new String();
	static String password = new String();
	//private static Properties props = new Properties();
	//private static Connection connection = null;
	
	static{
		try {
			className = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://192.200.102.41:3306/jy_hzxt";
			user = "root";
			password = "jyzx2020";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public MysqlTool() {	
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
    			System.out.println("数据库关闭成功！");
    			conn = null;
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
//	/**
//	 * 开始事务
//	 * @throws SQLException
//	 */
//	public void startTransaction(){
//		Connection conn = getConnection();
//		try {
//			conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 回滚事务
//	 * @throws SQLException
//	 */
//	public void rollback(){
//		Connection conn = getConnection();
//		try {
//			conn.rollback();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	/**
//	 * 提交事务
//	 * @throws SQLException
//	 */
//	public void commit(){
//		Connection conn = getConnection();
//		try {
//			conn.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void close(Connection conn){
//		try {
//			if(conn != null){
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
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
