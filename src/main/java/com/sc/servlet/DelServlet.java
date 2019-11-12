package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Item;
import com.sc.dao.GoodsDao;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] buygoods=request.getParameterValues("selectFlag");
		String bid1 =  request.getParameter("itemId");
		Item titem = new Item();
		
		for(int i=0;i<buygoods.length;i++){
			GoodsDao dao = new GoodsDao();
			int bid2 = Integer.valueOf(buygoods[i]);
			dao.deleteGoodsById(bid2);
		}
		
	     response.sendRedirect("GoodsSelect");
	}

}
