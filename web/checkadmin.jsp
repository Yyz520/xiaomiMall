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
    
    <title>后台查看商品</title>
    
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
    
    <script type="text/javascript">
      //全选/反选操作     
     function checkAll(ifAll) {   
        var select = document.getElementsByName("selectFlag");  
        for(var i = 0;i<select.length;i++){  
            select[i].checked = ifAll.checked;  
        }   
    } 
     
    </script>
    
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
            <div class="crumb-list"><i class="icon-font"></i><a href="backstagepage.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">查看商品信息</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                 <form action="SouAdmin" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="carname" id="carname" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post" action="DelAdmin">
             
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                      
                            <th class="tc" width="5%">管理员编号</th>
                            <th class="tc" width="5%">管理员名称</th>
                            <th class="tc" width="5%">管理员密码</th>
                            <th class="tc" width="5%">操作</th>
                        </tr>
                        <c:forEach items="${requestScope.li }" var="g">
                        <tr>
                           
                            <td align="center">${g.aid }</td>
                            <td align="center">${g.aname }</td>                            
                            <td align="center">${g.apassword }</td>
                            <td>
                            <a class="link-update" href="AdminGoUpdate?aid=${g.aid }" >修改</a>
                            <a class="link-del" href="DelAdmin?aid=${g.aid }" onclick="return window.confirm('确定删除？')">删除</a>
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