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
		//��ȡ��Ʒ��Ų���ֵ
		String itemIdStr=req.getParameter("itemId");
		int itemId=Integer.parseInt(itemIdStr);
		
		HttpSession session=req.getSession();
		List<Item> list=(List<Item>)session.getAttribute("gouwuche");
		if(list!=null){
			//ѭ���Ҽ����е���Ʒ������ҵ���ֱ�ӴӼ�����ɾ��
			for (int m = 0; m < list.size(); m++) {
				Item oldg=list.get(m);
				if(oldg.getItemId()==itemId){ //�ҵ�����Ʒ
					list.remove(m);
					break;
				}
			}
		}
		//�ѹ��ﳵ���ϴ���session
		session.setAttribute("gouwuche", list);
						
		//�ض��򵽹��ﳵҳ�棬�ɷ�ֹ�ظ�ˢ��
		resp.sendRedirect("gouwuche.jsp");
	}
}
