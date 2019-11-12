package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Item;
import com.sc.bean.Order;
import com.sc.bean.Item;
import com.sc.dao.GoodsDao;
import com.sc.dao.OrderDao;
import com.sc.dao.GoodsDao;

@WebServlet("/OrderGoUpdate")
public class OrderGoUpdate extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String oidStr = request.getParameter("oid");
	int oid = Integer.parseInt(oidStr);

	OrderDao dao = new OrderDao();
	Order o = dao.getOrderById(oid);

	request.setAttribute("o", o);

	request.getRequestDispatcher("updateOrder.jsp").forward(request, response);
}
}
