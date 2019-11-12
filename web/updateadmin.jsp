<%@page import="com.sc.bean.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台修改商品</title>
    
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
            <div class="crumb-list"><i class="icon-font"></i><a href="backstagepage.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="CheckGoods">查看商品信息</a><span class="crumb-step">&gt;</span><span>修改商品信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            <%Admin g = (Admin)request.getAttribute("g"); %>
                <form action="UpdateAdmin" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120">管理员编号：</th>
                            <td>
                             <input type="hidden" name="aid" value="${g.aid }">
                            </td>
                        </tr>
                            <th width="120">管理员姓名：</th>
                            <td>
                             <input class="common-text required" id="title" name="aname" size="50" value="<%=g.getAname() %>" type="text">
                            </td>
                        </tr>
                        <tr>
                                <th>管理员密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="apassword" size="50" value="<%=g.getApassword() %>" type="text">
                                </td>
                            </tr>
                        
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
  </body>
</html>
