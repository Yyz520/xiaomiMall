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
    
    <title>我的订单</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<script type="text/javascript">
		function checkform(){
			var utureName=document.myform.utureName.value;
			var utel=document.myform.utel.value;
			var uaddress=document.myform.uaddress.value;
			if(utureName==0){
				alert("收货人不能为空！");
				return false;
			}if(utel==0){
				alert("电话不能为空！");
				return false;
			}if(uaddress==0){
				alert("收货地址不能为空！");
				return false;
			}
		}		
		</script>
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="main.jsp"><div class="ad_top fl"></div></a>
			
			<div class="wdgwc fl ml40">我的订单</div>
			<div class="wxts fl ml20">
				温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算
			</div>
			<div class="dlzc fr">
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
		<div class="xiantiao"></div>
		<form  method="post" action="DingDanAdd" onsubmit="return checkform()" name="myform">
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
					</div>
					<div class="sub_top fl">
						收货人：<input type="text" value="${user.utureName }" name="utureName">
					</div>
					<div class="sub_top fl">
						电话：<input type="text" value="${user.utel}" name="utel">
					</div>
					<div class="sub_top fl">
					</div>
					<div class="sub_top fl">
						收货地址：<input type="text" value="${user.uaddress }" name="uaddress">
					</div>
					<div class="sub_top fr"></div>
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
					<div class="sub_content fl">${g.itemTolNum }</div>
					<div class="sub_content fl">${g.priceNormal*g.itemTolNum }</div>
					<div class="sub_content fl"></div>
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
							<div class="jsanniu fr"><input class="jsan" type="submit" name="queren"  value="确认购买"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			</form>
		</div>	
</html>

