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
		String pageNumStr=req.getParameter("pageNum");//��ȡ��ǰҳ������ֵ
		List<Item> list=new ArrayList<Item>();//�����Ʒ�ļ���
		
		Page p=new Page();
		if(pageNumStr!=null){
			int pageNum=Integer.parseInt(pageNumStr);
			p.setPageNum(pageNum);//��������Ҫ��ʾ�ĵ�ǰҳ��
		}
		
		GoodsDao dao=new GoodsDao();
		list=dao.selectGoodsPage(p);
		
		//��ѯ������������
		int count=dao.selectGoodsCount();
		p.setPageCount(count);
		//�ѷ�ҳ�������õ�request����
		req.setAttribute("p", p);
		//�Ѽ������õ�request����
		req.setAttribute("checkgoods", list);
		//ת������Ʒ�б�ҳ��
		req.getRequestDispatcher("checkgoods.jsp").forward(req, resp);
	}
	
}
