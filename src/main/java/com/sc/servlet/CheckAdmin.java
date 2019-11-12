package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sc.dao.AdminDao;

@WebServlet("/CheckAdmin")
public class CheckAdmin extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminDao dao = new AdminDao();
		List list =dao.selectAdmin();			
		request.setAttribute("li", list);		
		request.getRequestDispatcher("checkadmin.jsp").forward(request, response);       
	}
}
