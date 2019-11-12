package com.sc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConn {
	
	//获取数据库连接
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/onlineshop?useUnicode=true&characterEncoding=utf8";
			conn=DriverManager.getConnection(url, "root", "root");
		    System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		return conn;
	}
	//关闭资源
	public static void closeAll(ResultSet rs,PreparedStatement ps,Statement st,Connection conn){
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("关闭资源失败！");
		}
	}

}
