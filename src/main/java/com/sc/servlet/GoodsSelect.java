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
import com.sc.bean.Page;
import com.sc.dao.GoodsDao;

@WebServlet("/GoodsSelect")
public class GoodsSelect extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNumStr=req.getParameter("pageNum");//获取当前页数参数值
		List<Item> list=new ArrayList<Item>();//存放商品的集合
		
		Page p=new Page();
		if(pageNumStr!=null){
			int pageNum=Integer.parseInt(pageNumStr);
			p.setPageNum(pageNum);//重新设置要显示的当前页数
		}
		
		GoodsDao dao=new GoodsDao();
		list=dao.selectGoodsPage(p);
		
		//查询总条数并设置
		int count=dao.selectGoodsCount();
		p.setPageCount(count);
		//把分页对象设置到request对象
		req.setAttribute("p", p);
		//把集合设置到request对象
		req.setAttribute("checkgoods", list);
		//转发到商品列表页面
		req.getRequestDispatcher("checkgoods.jsp").forward(req, resp);
	}
	
}
