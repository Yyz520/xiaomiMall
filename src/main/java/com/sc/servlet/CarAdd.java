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
import com.sc.dao.ItemDao;

@WebServlet("/CarAdd")
public class CarAdd extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取商品编号参数值
		String itemIdStr=req.getParameter("itemId");
		int itemId=Integer.parseInt(itemIdStr);
		String shuliangStr=req.getParameter("shuliang");
		
				
		ItemDao dao=new ItemDao();
		Item i=dao.getItemById(itemId);
		
		HttpSession session=req.getSession();
		List<Item> list=(List<Item>)session.getAttribute("gouwuche");
		
		//定义购物车集合
		if(list==null){//第一次加入购物车
			list=new ArrayList<Item>();
			list.add(i);
		}else{
			boolean ishas=false;//默认不存在该商品
			//循环找集合中的商品，是否存在当前正要选购的商品
			for (int m = 0; m < list.size(); m++) {
				Item oldi=list.get(m);
				if(oldi.getItemId()==itemId){
					if(shuliangStr!=null&&!shuliangStr.equals("")){
						int shuliang=Integer.parseInt(shuliangStr);
						if(shuliang<=i.getItemNum()){
							oldi.setItemTolNum(shuliang);
						}else{
							oldi.setItemTolNum(i.getItemNum());
						}
						
					}else{
						int itemTolNum=oldi.getItemTolNum();
						if(itemTolNum<i.getItemNum()){
							oldi.setItemTolNum(itemTolNum+1);
						}else{
							oldi.setItemTolNum(i.getItemNum());
						}				    
					}
					ishas=true;
					break;
					}
				}
			if(!ishas){
				list.add(i);//不存在该商品，就添加
				}
			}
		//把购物车集合存入session
		session.setAttribute("gouwuche", list);
				
		//重定向到购物车页面，可防止重复刷新
		resp.sendRedirect("gouwuche.jsp");
	}
}
