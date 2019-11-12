package com.sc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.Order;
import com.sc.dao.OrderDao;

@WebServlet("/OrderManagerPage")
public class OrderManagerPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Order> list=new ArrayList<Order>();
		OrderDao dao1=new OrderDao();
		list=dao1.getOrder();
				
		req.setAttribute("list", list);
		req.getRequestDispatcher("checkorder.jsp").forward(req, resp);
	}
}
