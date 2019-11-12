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

@WebServlet("/Sousuo")
public class Sousuo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sousuo=req.getParameter("sousuo");
		
		ItemDao dao=new ItemDao();
		List<Item> list =new ArrayList<Item>();
		list=dao.Sou(sousuo);
		
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("sousuo.jsp").forward(req, resp);
		
	}
}
