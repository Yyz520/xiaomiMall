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
    
		<title>OPPO手机列表</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li>&nbsp;手机商城&nbsp;</li>
						<li>|</li>
						<li>&nbsp;MIUI&nbsp;</li>
						<li>|</li>
						<li>&nbsp;游戏&nbsp;</li>
						<li>|</li>
						<li>&nbsp;多看阅读&nbsp;</li>
						<li>|</li>
						<li>&nbsp;云服务&nbsp;</li>
						<li>|</li>
						<li>&nbsp;金融&nbsp;</li>
						<li>|</li>
						<li>&nbsp;问题反馈&nbsp;</li>
						<li>|</li>
						<li>&nbsp;Select Region&nbsp;</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="gouwuche.jsp">购物车</a></div>
					<div class="fr">
						<ul>
						<c:if test="${empty sessionScope.self.uname }">
							<li><a href="login.jsp">登录</a></li>
							<li>|</li>
							<li><a href="register.jsp">注册</a></li>
							<li>|</li>
						</c:if>
						<c:if test="${not empty sessionScope.self.uname }">
							<li>欢迎,${sessionScope.self.uname }&nbsp;&nbsp;</li>
							<li>|</li>
							<li><a href="Logout">退出</a></li>
							<li>|</li>
						</c:if>	
						<li><a href="main.jsp">首页</a></li>
						<li>|</li>
							<c:choose>
						<c:when test="${empty sessionScope.self.uname}">
							<li><a href="login.jsp" onclick="return window.confirm('登陆才能查看个人订单，是否登陆？');">&nbsp;&nbsp;个人订单&nbsp;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="DingDan">&nbsp;&nbsp;个人订单&nbsp;</a></li>
						</c:otherwise>
						</c:choose>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="main.jsp"><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="ItemSelect1?cid=1">小米手机</a></li>
					<li><a href="ItemSelect1?cid=2">华为手机</a></li>
					<li><a href="ItemSelect1?cid=3">vivo手机</a></li>
					<li><a href="ItemSelect1?cid=4">OPPO手机</a></li>
				</ul>
			</div>
		</div>
<!-- end banner_x -->

	<!-- start banner_y -->
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">OPPO手机</div>
			<div class="main center">
				<c:if test="${not empty requestScope.list }">
			<c:forEach items="${requestScope.list }" var="i" varStatus="st">
			<c:if test="${i.itemState==0 }">
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><a href="XiangQing?itemId=${i.itemId }"><img src="${i.itemPhoto }" alt=""></a></div>
					<div class="pinpai"><a href="XiangQing?itemId=${i.itemId }">${i.itemName }</a></div>
					<div class="youhui">${i.itemIntro }</div>
					<div class="jiage">${i.priceNormal }</div>
				</div>
				</c:if>
			</c:forEach>
			</c:if>
			</div>
		</div>
		
	</body>
</html>
