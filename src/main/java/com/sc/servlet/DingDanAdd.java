package com.sc.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.Item;
import com.sc.bean.Order;
import com.sc.bean.User;
import com.sc.dao.ItemDao;
import com.sc.dao.OrderDao;
import com.sc.dao.UserDao;

@WebServlet("/DingDanAdd")
public class DingDanAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String uname = (String)session.getAttribute("uname"); 
		
		UserDao dao=new UserDao();
		int uid=dao.getUserid(uname);
		
		String utel=req.getParameter("utel");
		String uaddress=req.getParameter("uaddress");
		
		List<Item> list=(List<Item>)session.getAttribute("gouwuche");
		
		OrderDao dao1=new OrderDao();
		
		ItemDao dao2=new ItemDao();
		
		for(int m=0;m<list.size();m++){
			Item oldg=(Item)list.get(m);
			int iid=oldg.getItemId();
			String iname=oldg.getItemName();
			float iprice=oldg.getPriceNormal();
			int inumber=0;
			if((oldg.getItemTolNum()+1)>oldg.getItemNum()){
				 inumber=oldg.getItemNum();
			}else{
				 inumber=oldg.getItemTolNum();
			}
			float isum=iprice*inumber;
			System.out.println("isum="+isum);
			String iphoto=oldg.getItemPhoto();
			String date=new Date().toLocaleString();
			
			Order g=new Order(0,uid,uname,utel,uaddress,iid,iname,iprice,inumber,isum,iphoto,date,"1","1","1","1");
			dao1.addOrder(g);
			
			dao2.updateitem(iid,inumber);
		}
		req.getSession().removeAttribute("gouwuche");
		
		resp.sendRedirect("ok.jsp");
	}
}
