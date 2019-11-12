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
		//��ȡ��Ʒ��Ų���ֵ
		String itemIdStr=req.getParameter("itemId");
		int itemId=Integer.parseInt(itemIdStr);
		String shuliangStr=req.getParameter("shuliang");
		
				
		ItemDao dao=new ItemDao();
		Item i=dao.getItemById(itemId);
		
		HttpSession session=req.getSession();
		List<Item> list=(List<Item>)session.getAttribute("gouwuche");
		
		//���幺�ﳵ����
		if(list==null){//��һ�μ��빺�ﳵ
			list=new ArrayList<Item>();
			list.add(i);
		}else{
			boolean ishas=false;//Ĭ�ϲ����ڸ���Ʒ
			//ѭ���Ҽ����е���Ʒ���Ƿ���ڵ�ǰ��Ҫѡ������Ʒ
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
				list.add(i);//�����ڸ���Ʒ�������
				}
			}
		//�ѹ��ﳵ���ϴ���session
		session.setAttribute("gouwuche", list);
				
		//�ض��򵽹��ﳵҳ�棬�ɷ�ֹ�ظ�ˢ��
		resp.sendRedirect("gouwuche.jsp");
	}
}
