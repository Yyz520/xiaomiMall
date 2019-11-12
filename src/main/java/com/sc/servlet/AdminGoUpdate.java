package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Admin;
import com.sc.bean.Item;
import com.sc.bean.Item;
import com.sc.dao.AdminDao;
import com.sc.dao.GoodsDao;
import com.sc.dao.GoodsDao;

@WebServlet("/AdminGoUpdate")
public class AdminGoUpdate extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String aidStr = request.getParameter("aid");
	int aid = Integer.parseInt(aidStr);
	AdminDao dao = new AdminDao();
	Admin g=dao.getAdminById(aid);

	request.setAttribute("g", g);

	request.getRequestDispatcher("updateadmin.jsp").forward(request, response);
}
}
