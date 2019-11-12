package com.sc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	//��ȡ���ݿ�����
	public static Connection getConn(){
		Connection conn=null;
		
		try {
			//1�����ؼ�ע����������
			Class.forName("com.mysql.jdbc.Driver");//��������
			System.out.println("���ؼ�ע����������ɹ���");
			
			//2��ͨ����������������ȡ���ݿ����Ӷ���
			String url="jdbc:mysql://localhost:3306/onlineshop";
			conn=DriverManager.getConnection(url, "root", "root");
			System.out.println("�������ݿ�ɹ���");
			
		} catch (ClassNotFoundException e) {
			System.out.println("���ؼ�ע����������ʧ�ܣ�");
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
		}
		
		return conn;
	}
	
	//�ر�������Դ
	public static void closeAll(ResultSet rs,
			                    PreparedStatement ps,
			                    Statement st,
			                    Connection conn){
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
			System.out.println("�ر���Դ�ɹ���");
		} catch (SQLException e) {
			System.out.println("�ر���Դʧ�ܣ�");
		}
	}
	
}
