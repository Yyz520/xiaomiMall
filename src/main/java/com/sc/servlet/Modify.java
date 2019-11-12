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

@WebServlet("/Modify")
public class Modify extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String upassword=req.getParameter("upassword");
		String  uname=req.getParameter("uname");
		Connection conn=null;
		Statement st=null;
		Object rs=null;
		boolean  isSuccess=false;	
		try {
			conn= DataConn.getConn();
			st=conn.createStatement();			
			String sql="update t_user set upassword='"+upassword+"' where uname='"+uname +"'" ;
			System.out.println("要执行的sql语句是"+sql);
			rs=st.executeUpdate(sql);
			
			isSuccess=true;
			
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
		}finally {
			try {
				if(st!=null)st.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e2) {
				System.out.println("资源关闭失败");
			}
		}
		if(isSuccess){			
			HttpSession session=req.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("upassword", upassword);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("retrieve .jsp").forward(req, resp);
		}	
		
	}
}
