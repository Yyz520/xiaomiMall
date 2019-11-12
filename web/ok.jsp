<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购买成功</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">			
			<div class="wdgwc fl ml40">购买成功！</div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="main.jsp">继续购物</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
							<div class="jsanniu fr"><a href="DingDan"><input class="jsan" type="submit" name="queren"  value="查看订单"/></a></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>	
</html>

