package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Admin;
import com.sc.dao.AdminDao;
import com.sc.dao.GoodsDao;

@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//获取参数值
		
		String aname=req.getParameter("aname");
		String apassword=req.getParameter("apassword");
		String aidStr=req.getParameter("aid");
		int aid=Integer.parseInt(aidStr);
		
		
		//封装成商品对象
		Admin g=new Admin(aid, aname, apassword);	
		//调用修改方法
		AdminDao dao=new AdminDao();
		dao.updateAdmin(g);
		
		//重定向
		resp.sendRedirect("CheckAdmin");
	}
}
