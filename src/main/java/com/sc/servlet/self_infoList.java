package com.sc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JPasswordField;

import com.sc.bean.User;
import com.sc.dao.UserDao;

@WebServlet("/self_infoList")
public class self_infoList extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list=new ArrayList<User>();//存放商品
		
		UserDao u=new UserDao();
		

		//把集合设置到request对象		
		req.setAttribute("self_infolist", list);
		
		//转发到商品列表页面
		req.getRequestDispatcher("goodslist.jsp").forward(req, resp);
	}

}
