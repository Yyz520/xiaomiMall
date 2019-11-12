package com.sc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.sc.bean.User;
import com.sc.dao.DataConn;
import com.sc.dao.UserDao;


@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uname=req.getParameter("uname");
		String upassword=req.getParameter("upassword");
		String utureName=req.getParameter("utureName");
		
		//ע����֤�û����ظ�,�������û��������ʵ���������� 
		UserDao dao=new UserDao();
		Boolean b=dao.ndql(uname);
		if(b){
			req.setAttribute("upassword", upassword);
			req.setAttribute("utureName", utureName);
			req.getRequestDispatcher("register.jsp?b==yes").forward(req, resp);			
			return;
		}
		
		
		Connection conn=null;
		
		Statement st=null;
		int i=-1;//Ĭ��ʧ��
		
		
		try {
			
			
			conn= DataConn.getConn();
			st=conn.createStatement();			
			String sql="insert into t_user(uname,utureName,upassword) values('"+uname+"','"+utureName+"','"+upassword+"')";
			System.out.println("Ҫִ�е�sql�����"+sql);
			i=st.executeUpdate(sql);
			if(i!=-1)System.out.println("�����ɹ�");
			else System.out.println("����ʧ��");			
			
		} catch (SQLException e) {
          // System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
			
		}finally {
			try {
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e2) {
				System.out.println("��Դ�ر�ʧ��");
			}
		}
		if(i!=-1){
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}else{
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}		
		
	}

}
