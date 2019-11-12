<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

   <link rel="stylesheet" type="text/css" href="css1/common.css"/>
   <link rel="stylesheet" type="text/css" href="css1/main.css"/>
      

  </head>
  
  <body>
    <div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="backstagepage.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>欢迎, ${aname}</li>
                <li><a href="adminlogin.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">     
       <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <i class="icon-font"></i>网上商城管理平台
                    <ul class="sub-menu">
                        <li><a href="GoodsSelect"><i class="icon-font"></i>查看商品</a></li>
                        <li><a href="OrderManagerPage"><i class="icon-font"></i>订单详情</a></li>
                        <li><a href="CheckUsers"><i class="icon-font"></i>查看用户</a></li>
                        <li><a href="CheckAdmin"><i class="icon-font"></i>查看管理员</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
         <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="backstagepage.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">查看订单信息</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
              <form action="SouOrder" method="post">
                    <table class="search-tab">
                        
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post" action="">
                <div class="result-title">
                    <div class="result-list">
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            
                            <th>订单编号</th>
 							<th>用户编号</th>
                            <th>用户名称</th>
							<th>送货电话</th>
							<th>送货地址</th>
 							<th>商品编号</th>
 							<th>商品名称</th>
							<th>商品单价</th>
 							<th>商品数量</th>
							<th>商品总价</th>
							<th>商品图片</th>
							<th>购买日期</th>
							<th>是否送货</th>
							
  							
     						<th>操作</th>
                        </tr>
                        <c:forEach items="${requestScope.list }" var="g">
                        <tr>
                            
                            <td align="center">${g.oid }</td>
                            <td align="center">${g.uid }</td>
                            <td align="center">${g.uname }</td>
                            <td align="center">${g.utel }</td>
                            <td align="center">${g.uaddress }</td>
                            <td align="center">${g.iid }</td>
                            <td align="center">${g.iname }</td>
                            <td align="center">${g.iprice }</td>
                            <td align="center">${g.inumber }</td>
                            <td align="center">${g.isum }</td>
                            <td align="center">
                            
                            <a href="GoodsDownLoad?fname=${g.iphoto  }"></a>
                            <img src="upload/${g.iphoto }" width="100" height="100">
                            </td>
                            
                            <td align="center">${g.oshopDate }</td>
                            
                            <c:if test="${g.oisSend==1}">
                            <td align="center">未发货</td>
                            </c:if>
                             <c:if test="${g.oisSend==0}">
                            <td align="center">已发货</td>
                            </c:if>
                          

                          <!--   <td height="58" bgcolor="#FFFFFF"><div align="center">   -->
                            <td>
                                <a class="link-update" href="OrderGoUpdate?oid=${g.oid}">修改</a>
                             
                            </td>
                          </tr>
                        
                        </c:forEach>
                    </table>
                    
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
  </body>
</html>
