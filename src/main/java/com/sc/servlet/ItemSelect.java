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

@WebServlet("/ItemSelect")
public class ItemSelect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Item> list=new ArrayList<Item>();//存放商品的集合
		
		ItemDao dao=new ItemDao();
		list=dao.selectItem();
		
		//把集合设置到request对象
		req.setAttribute("list", list);
		//转发到商品列表页面
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}
