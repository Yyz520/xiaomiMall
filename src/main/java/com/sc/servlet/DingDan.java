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

import com.sc.bean.Item;
import com.sc.bean.Order;
import com.sc.dao.OrderDao;
import com.sc.dao.UserDao;

@WebServlet("/DingDan")
public class DingDan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String uname = (String)session.getAttribute("uname"); 
		UserDao dao=new UserDao();
		int uid=dao.getUserid(uname);
		
		List<Order> list=new ArrayList<Order>();
		OrderDao dao1=new OrderDao();
		list=dao1.getOByuid(uid);
				
		req.setAttribute("list", list);
		req.getRequestDispatcher("dingdan.jsp").forward(req, resp);
	}
}
