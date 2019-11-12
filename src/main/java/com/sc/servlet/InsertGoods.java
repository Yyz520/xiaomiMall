package com.sc.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sc.bean.Item;
import com.sc.bean.Item;
import com.sc.dao.GoodsDao;

@WebServlet("/InsertGoods")
public class InsertGoods extends HttpServlet {
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1、实例化上传组件
			SmartUpload su=new SmartUpload();
		//2、初始化组件
			su.initialize(getServletConfig(), req, resp);
			String gpic=null;
			try {
				//3、文件从客户端上传到服务器
				su.upload();
				//4、获取文件对象
				File f=su.getFiles().getFile(0);
				//5、判断用户是否选择了文件
				if(!f.isMissing()){
					//获取服务器上存储图片的路径
					//例如：D:\\apache-tomcat-8.5.6-teach\\webapps\\jsp7\\upload
					String path=req.getServletContext().getRealPath("upload");
					System.out.println("保存的路径是："+path);
					//6、把文件另存到服务器
					f.saveAs(path+"/"+f.getFileName());
					//获取文件名称
					gpic=f.getFileName();
				}else{
					gpic=su.getRequest().getParameter("gpic");
				}
			} catch (SmartUploadException e) {
				System.out.println("文件上传失败！");
			}
			System.out.println("kkk");
			String itemName=su.getRequest().getParameter("itemName");
			String cidStr=su.getRequest().getParameter("cid");
			int cid=Integer.parseInt(cidStr);
			String itemProductor = su.getRequest().getParameter("itemProductor");
		    String itemIntro = su.getRequest().getParameter("itemIntro");		       
		    String priceVipStr = su.getRequest().getParameter("priceVip");
		    float priceVip = Float.parseFloat(priceVipStr);
		    String priceNormalStr = su.getRequest().getParameter("priceNormal");
		    float priceNormal = Float.parseFloat(priceNormalStr);			   
   		    String itemNumStr = su.getRequest().getParameter("itemNum");
			int itemNum = Integer.parseInt(itemNumStr);
			String itemTolNumStr = su.getRequest().getParameter("itemTolNum");
			int itemTolNum = Integer.parseInt(itemTolNumStr);			
			String itemState=su.getRequest().getParameter("ItemState");
			Item g = new Item(0, itemName, cid, itemProductor, gpic, itemIntro, priceVip, priceNormal, itemNum, itemTolNum, "0");
			GoodsDao dao = new GoodsDao();
			dao.addGoods(g);
			
			resp.sendRedirect("GoodsSelect");
	}

}
