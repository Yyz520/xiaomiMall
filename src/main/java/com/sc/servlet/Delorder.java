package com.sc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.OrderDao;

@WebServlet("/Delorder")
public class Delorder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oidStr=request.getParameter("oid");
		int oid=Integer.parseInt(oidStr);		
		//调用删除方法
		OrderDao dao=new OrderDao();
		dao.deleteOrderById(oid);
		
		//重定向
		
	     response.sendRedirect("OrderManagerPage");
	}

}
