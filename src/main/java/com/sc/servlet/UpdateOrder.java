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
          //1ʵ�����ϴ����
                  SmartUpload su=new SmartUpload();
                  //2��ʼ�����
                  su.initialize(getServletConfig(), request, response);
                  String gpic=null;
                  try {
                      //3�ļ��ӿͻ����ϴ���������
                      su.upload();
                      //4��ȡ�ļ�����
                      File f=su.getFiles().getFile(0);
                      //5�ж��û��Ƿ�ѡ�����ļ�
                      if(!f.isMissing()){
                          //��ȡ�������ϴ洢ͼƬ��·��
                          String path=request.getServletContext().getRealPath("upload");
                          System.out.println("�����·����:"+path);
                      //6���ļ���浽������
                          f.saveAs(path+"/"+f.getFileName());
                          //��ȡ�ļ�����
                          gpic=f.getFileName();
                      }else{
                          gpic=su.getRequest().getParameter("gpic");
                      }
                  } catch (SmartUploadException e) {
                      System.out.println("�ļ��ϴ�ʧ��");
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
