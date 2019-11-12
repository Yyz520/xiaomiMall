package com.sc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.UserDao;

@WebServlet("/CheckUsers")
public class CheckUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao dao = new UserDao();
		List list=dao.selectUsers();
      	request.setAttribute("li", list);
		request.getRequestDispatcher("checkusers.jsp").
				            forward(request, response);
	}

}
