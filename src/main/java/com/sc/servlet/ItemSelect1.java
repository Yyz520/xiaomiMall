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

@WebServlet("/ItemSelect1")
public class ItemSelect1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��Ʒ�����Ų���ֵ
		String cidStr=req.getParameter("cid");
		int cid=Integer.parseInt(cidStr);
		
		List<Item> list=new ArrayList<Item>();//�����Ʒ�ļ���
			
		ItemDao dao=new ItemDao();
		list=dao.getGoodsBycid(cid);
			
		//�Ѽ������õ�request����
		req.setAttribute("list", list);
		if(cid==1){
			req.getRequestDispatcher("mphone.jsp").forward(req, resp);
		}else if(cid==2){
			req.getRequestDispatcher("hphone.jsp").forward(req, resp);
		}else if(cid==3){
			req.getRequestDispatcher("vphone.jsp").forward(req, resp);
		}else if(cid==4){
			req.getRequestDispatcher("ophone.jsp").forward(req, resp);
		}		
	}
}
