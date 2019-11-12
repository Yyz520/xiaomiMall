package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Item;
import com.sc.bean.User;
import com.sc.dao.ItemDao;
import com.sc.dao.UserDao;

@WebServlet("/JieSuan")
public class JieSuan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		
		
		UserDao dao=new UserDao();
		User u=dao.getUserByname(uname);
		
		req.setAttribute("user", u);
		req.getRequestDispatcher("jiesuan.jsp").forward(req, resp);
	}
}
