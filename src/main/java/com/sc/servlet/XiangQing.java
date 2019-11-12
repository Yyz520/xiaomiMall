package com.sc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Item;
import com.sc.dao.ItemDao;

@WebServlet("/XiangQing")
public class XiangQing extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取商品编号参数值
		String itemIdStr=req.getParameter("itemId");
		int itemId=Integer.parseInt(itemIdStr);
		
		ItemDao dao=new ItemDao();
		Item i=dao.getItemById(itemId);
		
		req.setAttribute("item", i);
		req.getRequestDispatcher("xiangqing.jsp").forward(req, resp);
	}
}
