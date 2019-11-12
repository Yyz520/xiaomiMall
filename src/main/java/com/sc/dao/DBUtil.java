package com.sc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	//获取数据库连接
	public static Connection getConn(){
		Connection conn=null;
		
		try {
			//1、加载及注册驱动程序
			Class.forName("com.mysql.jdbc.Driver");//驱动类名
			System.out.println("加载及注册驱动程序成功！");
			
			//2、通过驱动管理器，获取数据库连接对象
			String url="jdbc:mysql://localhost:3306/onlineshop";
			conn=DriverManager.getConnection(url, "root", "root");
			System.out.println("连接数据库成功！");
			
		} catch (ClassNotFoundException e) {
			System.out.println("加载及注册驱动程序失败！");
		} catch (SQLException e) {
			System.out.println("连接数据库失败！");
		}
		
		return conn;
	}
	
	//关闭所有资源
	public static void closeAll(ResultSet rs,
			                    PreparedStatement ps,
			                    Statement st,
			                    Connection conn){
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
			System.out.println("关闭资源成功！");
		} catch (SQLException e) {
			System.out.println("关闭资源失败！");
		}
	}
	
}
