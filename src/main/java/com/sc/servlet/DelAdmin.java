package com.sc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.AdminDao;


@WebServlet("/DelAdmin")
public class DelAdmin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aidStr=request.getParameter("aid");
		int aid=Integer.parseInt(aidStr);		
		//调用删除方法
		AdminDao dao=new AdminDao();
		dao.deleteAdminById(aid);
		
		//重定向
		
	     response.sendRedirect("CheckAdmin");
	}

}
