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
    
    <title>个人订单</title>
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
					<div class="gouwuche fr"><a href="self_info.jsp">个人中心</a></div>
					<div class="fr">
						<ul>
							<li>欢迎,${sessionScope.self.uname }&nbsp;&nbsp;</li>
							<li>|</li>
							<li><a href="Logout">退出</a></li>
							<li>|</li>
							<li><a href="main.jsp">首页</a></li>
							<li>|</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="DingDan" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
					<li>意外保</li>
					<li>团购订单</li>
					<li>评价晒单</li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li>我的个人中心</li>
					<li>消息通知</li>
					<li>优惠券</li>
					<li>收货地址</li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			<c:if test="${empty requestScope.list }">
			<br><h2>暂无订单信息</h2>
			</c:if>
			<c:if test="${not empty requestScope.list }">
			<c:forEach items="${requestScope.list }" var="l" varStatus="st">			
			<div class="ddxq">
				<div class="ddspt fl"><img src="${l.iphoto }" width="100px" height="100px"></div>
				<div class="ddbh fl">订单号:${l.oid }</div>
				<div class="ztxx fr">
					<ul>
						<li>${l.iname }</li>
						<li>数量：${l.inumber }</li>
						<li>￥${l.isum }</li>
						<li style="width: 200px">${l.oshopDate }</li>
						<c:if test="${l.oisSend==1 }">					
						<li style="width: 80px">未发货</li>	
						</c:if>
						<c:if test="${l.oisSend==0 }">					
						<li style="width: 80px">已发货</li>	
						</c:if>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>		
			</c:forEach>
			</c:if>
		</div>
		<div class="clear"></div>
		</div>
	</div>
	</body>
</html>