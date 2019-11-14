package com.sc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.dao.DataConn;

@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		String utureName=req.getParameter("utureName");

		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		boolean  isSuccess=false;	
		try {
			conn= DataConn.getConn();
			st=conn.createStatement();			
			String sql="select * from t_user where uname='"+uname+"' and utureName='"+utureName+"'";
			System.out.println("Ҫִ�е�sql�����"+sql);
			rs=st.executeQuery(sql);
			while(rs!=null&&rs.next()){
				isSuccess=true;
			}
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��");
		}finally {
			try {
				if(st!=null)st.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e2) {
				System.out.println("��Դ�ر�ʧ��");
			}
		}
		if(isSuccess){			
			HttpSession session=req.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("utureName", utureName);
			//�ɹ�
			req.getRequestDispatcher("modify.jsp").forward(req, resp);
		}else{
			//ʧ��
			req.getRequestDispatcher("retrieve.jsp?codaq==erro").forward(req, resp);
		}	
		
	}
		
}


