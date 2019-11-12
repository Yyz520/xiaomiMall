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
import com.sc.bean.Order;
import com.sc.dao.GoodsDao;
import com.sc.dao.OrderDao;

  @WebServlet("/UpdateOrder")
  public class UpdateOrder extends HttpServlet {
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

          String oidStr=su.getRequest().getParameter("oid");
          int oid=Integer.parseInt(oidStr);
          String uidStr=su.getRequest().getParameter("uid");
          int uid=Integer.parseInt(uidStr);
          String uname=su.getRequest().getParameter("uname");
          String utel=su.getRequest().getParameter("utel");
          String uaddress = su.getRequest().getParameter("uaddress");
          String iidStr=su.getRequest().getParameter("iid");
          int iid=Integer.parseInt(iidStr);
          String iname = su.getRequest().getParameter("iname");
          String ipriceStr = su.getRequest().getParameter("iprice");
          Float iprice = Float.parseFloat(ipriceStr);
          String inumberStr=su.getRequest().getParameter("inumber");
          int inumber=Integer.parseInt(inumberStr);
          String isumStr = su.getRequest().getParameter("isum");
          Float isum = Float.parseFloat(isumStr);
          String oshopDate= su.getRequest().getParameter("oshopDate");
          String oisSend=su.getRequest().getParameter("oisSend");

          Order g = new Order(oid, uid, uname, utel, uaddress, iid, iname, iprice, inumber, isum, gpic, oshopDate,oisSend,"1","1","1");
          OrderDao dao = new OrderDao();
          dao.updateOrder(g);

          response.sendRedirect("OrderManagerPage");
      }

  }
