package com.sc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.UserDao;

@WebServlet("/DelUser")
public class DelUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uidStr=request.getParameter("uid");
		int uid=Integer.parseInt(uidStr);		
		//调用删除方法
		UserDao dao=new UserDao();
		dao.deleteUserById(uid);
		
		//重定向
		
	     response.sendRedirect("CheckUsers");
	}

}
