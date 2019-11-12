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
    <title>商品详情</title>
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

	<!-- xiangqing -->
	<form action="XiangQing" method="post" enctype="multipart/form-data">
	<c:set var="i" value="${requestScope.item }" > </c:set>
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">${i.itemName }</div>
			<nav class="fr">
				<li>概述</li>
				<li>|</li>
				<li>变焦双摄</li>
				<li>|</li>
				<li>设计</li>
				<li>|</li>
				<li>参数</li>
				<li>|</li>
				<li>F码通道</li>
				<li>|</li>
				<li>用户评价</li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><img src="${i.itemPhoto }"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20">${i.itemName }</div>
			<div class="jianjie mr40 ml20 mt10">${i.itemIntro }</div>
			<div class="jiage ml20 mt10">${i.priceNormal }元</div>
			<div class="ft20 ml20 mt20">版本</div>
			<div class="xzbb ml20 mt10">
				<div class="banben fl">
					<a>
						<span>全网通版 6GB+64GB </span>
						<span>${i.priceNormal }元</span>
					</a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ft20 ml20 mt20">颜色</div>
			<div class="xzbb ml20 mt10">
				<div class="banben">
					<a>
						<span class="yuandian"></span>
						<span class="yanse">亮黑色</span>
					</a>
				</div>
				
			</div>
			<div class="xqxq mt20 ml20">
				<div class="top1 mt10">
					<div class="left1 fl">${i.itemName }&nbsp;&nbsp;&nbsp;${i.itemIntro }</div>
					<div class="right1 fr">${i.priceNormal }元</div>
					<div class="clear"></div>
				</div>
				
			</div>
			<div class="xiadan ml20 mt20">
					<input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
				<c:choose>
						<c:when test="${i.itemNum==0}">
							<a href="main.jsp" onclick="return window.confirm('没有库存，请返回首页！');"><input class="jrgwc" type="button" name="jrgwc" value="加入购物车" /></a>
						</c:when>
						<c:otherwise>
							<a href="CarAdd?itemId=${i.itemId }"><input class="jrgwc" type="button" name="jrgwc" value="加入购物车" /></a>
						</c:otherwise>
					</c:choose>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	<!-- footer -->
	<footer class="mt20 center">			
			<div class="mt20">手机商城|MIUI|多看书城|视频电话|手机天猫店|手机淘宝直营店|手机网盟|手机移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>