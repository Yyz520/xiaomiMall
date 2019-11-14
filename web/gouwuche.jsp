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
    
    <title>购物车</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="main.jsp"><div class="ad_top fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">
				温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算
			</div>
			<div class="dlzc fr">
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
		<div class="xiantiao"></div>
		<c:if test="${empty sessionScope.gouwuche }">
	<div align="center">
		<h1> 对不起，您的购物车为空！点击图片进入购买</h1>
		<a href="main.jsp"><img src="images/nullcart.gif"></a>
	</div>
        </c:if>
        <c:if test="${not empty sessionScope.gouwuche }">
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<c:set var="sum" value="0.00"></c:set>
				<c:forEach items="${sessionScope.gouwuche}" var="g" varStatus="st">
				<div class="content2 center">
					<div class="sub_content fl ">
					</div>
					<div class="sub_content fl"><img src="${g.itemPhoto }" width="100px" height="100px"></div>
					<div class="sub_content fl ft20">${g.itemName }</div>
					<div class="sub_content fl ">${g.priceNormal }</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="${g.itemTolNum  }" step="1" min="1" id="shuliang-${g.itemId }" onchange="changeprice(${g.itemId })">
					</div>
					<div class="sub_content fl">${g.priceNormal*g.itemTolNum }</div>
					<div class="sub_content fl"><a href="CarDelete?itemId=${g.itemId }" onclick="return window.confirm('是否确定移除该商品？');">×</a></div>
					<c:set var="sum" value="${sum+g.priceNormal*g.itemTolNum }"></c:set>
					<div class="clear"></div>
				</div>
				</c:forEach>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="main.jsp">继续购物</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>${sum }</span></div>
					<c:choose>
						<c:when test="${empty sessionScope.self.uname}">
							<div class="jsanniu fr"><a href="login.jsp" onclick="return window.confirm('登陆才能去结算，是否登陆？');"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></a></div>
						</c:when>
						<c:otherwise>
							<div class="jsanniu fr"><a href="JieSuan?uname=${sessionScope.uname }"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></a></div>
						</c:otherwise>
					</c:choose>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>	
		</c:if>
		
		<script type="text/javascript">
	 function changeprice(gid){
	
	    var shuliang=document.getElementById("shuliang-"+gid).value;
    																																																					
	    	window.location.href="CarAdd?itemId="+gid+"&shuliang="+shuliang;
	 }
	</script>		
</html>

