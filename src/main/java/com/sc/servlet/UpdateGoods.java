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
import com.sc.dao.GoodsDao;

  @WebServlet("/UpdateGoods")
  public class UpdateGoods extends HttpServlet {
      public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //1实例化上传组件
                  SmartUpload su=new SmartUpload();
                  //2初始化组件
                  su.initialize(getServletConfig(), request, response);
                  String gpic=null;
                  try {
                      //3文件从客户端上传到服务器
                      su.upload();
                      //4获取文件对象
                      File f=su.getFiles().getFile(0);
                      //5判断用户是否选择了文件
                      if(!f.isMissing()){
                          //获取服务器上存储图片的路径
                          String path=request.getServletContext().getRealPath("upload");
                          System.out.println("保存的路径是:"+path);
                      //6把文件另存到服务器
                          f.saveAs(path+"/"+f.getFileName());
                          //获取文件名称
                          gpic=f.getFileName();
                      }else{
                          gpic=su.getRequest().getParameter("gpic");
                      }
                  } catch (SmartUploadException e) {
                      System.out.println("文件上传失败");
                  }

          String itemIdStr=su.getRequest().getParameter("itemId");
          int itemId=Integer.parseInt(itemIdStr);
          String itemName=su.getRequest().getParameter("itemName");
          String cidStr=su.getRequest().getParameter("cid");
          int cid=Integer.parseInt(cidStr);
          String itemProductor = su.getRequest().getParameter("itemProductor");
          String itemIntro = su.getRequest().getParameter("itemIntro");
          String priceVipStr = su.getRequest().getParameter("priceVip");
          Float priceVip = Float.parseFloat(priceVipStr);
          String priceNormalStr = su.getRequest().getParameter("priceNormal");
          Float priceNormal = Float.parseFloat(priceNormalStr);
          String itemNumStr = su.getRequest().getParameter("itemNum");
          int itemNum = Integer.parseInt(itemNumStr);
          String itemTolNumStr = su.getRequest().getParameter("itemTolNum");
          int itemTolNum = Integer.parseInt(itemTolNumStr);
          String itemState=su.getRequest().getParameter("itemState");

          Item g = new Item(itemId, itemName, cid, itemProductor, gpic, itemIntro, priceVip, priceNormal, itemNum, itemTolNum,itemState );
          GoodsDao dao = new GoodsDao();
          dao.updateGoods(g);

          response.sendRedirect("GoodsSelect");
      }

  }
