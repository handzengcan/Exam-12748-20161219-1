package com.maven.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

	public static final String url = "jdbc:mysql://127.0.0.1/sakila";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "zengcan";

	public static Connection conn = null;
	public static PreparedStatement pst = null;

	public static Connection getDBConnection() {
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);// 获取连接
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pst = conn.prepareStatement(sql);//准备执行语句
		return conn;
	}
	
	public static PreparedStatement getPreparedStatement(String sql){
		
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pst;
	}

	public static  void close() {
		try {
			 conn.close();
			 pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	 /* public static void main(String[] args) { 
		  DBConnection connection = new
	  DBConnection(); 
		  Connection connection2 = connection.getDBConnection(); 
		  System.out.println(connection2);
	  }*/
	 
}
