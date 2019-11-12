package com.sc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.Item;

@WebServlet("/CarDelete")
public class CarDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取商品编号参数值
		String itemIdStr=req.getParameter("itemId");
		int itemId=Integer.parseInt(itemIdStr);
		
		HttpSession session=req.getSession();
		List<Item> list=(List<Item>)session.getAttribute("gouwuche");
		if(list!=null){
			//循环找集合中的商品，如果找到，直接从集合中删除
			for (int m = 0; m < list.size(); m++) {
				Item oldg=list.get(m);
				if(oldg.getItemId()==itemId){ //找到该商品
					list.remove(m);
					break;
				}
			}
		}
		//把购物车集合存入session
		session.setAttribute("gouwuche", list);
						
		//重定向到购物车页面，可防止重复刷新
		resp.sendRedirect("gouwuche.jsp");
	}
}
