package com.sc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.Admin;
import com.sc.dao.AdminDao;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String aname=req.getParameter("aname");
		String apassword=req.getParameter("apassword");
		System.out.println("用户名是"+aname);		
		AdminDao dao = new AdminDao();
		Admin u=dao.Login(aname, apassword);
		if(u!=null){			
			HttpSession session=req.getSession();
			session.setAttribute("aname", aname);
			resp.sendRedirect("adminmain.jsp");
		}else{
			resp.sendRedirect("adminlogin.jsp");
		}
		
	}
}
