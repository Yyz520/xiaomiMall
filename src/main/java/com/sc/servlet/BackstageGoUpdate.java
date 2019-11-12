package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Item;
import com.sc.dao.GoodsDao;

@WebServlet("/BackstageGoUpdate")
public class BackstageGoUpdate extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String itemIdStr = request.getParameter("itemId");
	int itemId = Integer.parseInt(itemIdStr);
	System.out.println(itemId);
	GoodsDao dao = new GoodsDao();
	Item g = dao.getGoodsById(itemId);

	request.setAttribute("g", g);

	request.getRequestDispatcher("updategoods.jsp").forward(request, response);
}
}
