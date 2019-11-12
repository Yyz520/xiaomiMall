<%@page import="com.sc.dao.UserDao"%>
<%@page import="com.sc.bean.User"%>
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
		<title>我的个人中心</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<script type="text/javascript">
		
		function checkform(){
			var uname=document.myform.uname.value;//用户名
			var upassword=document.myform.upassword.value;//密码
			var uemail=document.myform.uemail.value;//邮箱
			/* var rupassword=document.myform.rupassword.value */
			var utureName=document.myform.utureName.value;//真实姓名
			var uaddress=document.myform.uaddress.value;//收货地址
			var  reg2 = /^[\u4e00-\u9fa5]{2,4}$/;
			 var regobj=/^\w+([\.-]\w+)*@\w+([\.-]\w+)*(\.[a-zA-Z]{2,3})/;
			 
			if(uname==0){
				alert("用户名不能为空");
				return false;
			}
			if(rupassword!=upassword){
				alert("两次密码不一致");
				return false;
			}if(!( /^[\u0391-\uFFE5]+$/.test(utureName))){
				alert("真实姓名格式不正确，请重新输入");
				return false;
			}else{
			if(utureName==0){
			alert("用户名不能为空");
			return false;
				}
			}
	
		}
		
		
		</script>
		
		<script type="text/javascript">
		
		function checkform(){
		var uemail=document.myform.uemail.value;//邮箱
		var ob= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(!ob.test(uemail)){
		alert("电子邮箱不正确");
			return false;
		}
	}
	
		
		
		</script>
		<script type="text/javascript">
		function checkform(){
		var upassword=document.myform.upassword.value;//密码
		var reg = /^[\w]{6,12}$/;
		if(upassword==0){
				alert("密码不能为空");
				return false;
			}else{
				var reg = /^[\w]{6,12}$/;
			if(!upassword.match(reg)){
    			 alert("密码由6-12位数字和字母组成!");
    			 return false;
						}
		}
	}
		
		
		</script>
		</script>
		<script type="text/javascript">
		function checkform(){
		var utel=document.myform.utel.value;//手机号
		var rrg =/^1[3|4|5|7|8][0-9]{9}$/;
		if(!rrg.test(utel)){ 
		 alert("手机号码有误，请重填");  
			return false; 
		
		}
		
	}
		
		
		</script>
		
	</head>
	<body>
	<!-- start header -->
	<form action="UserUptate" method="post" onsubmit="return checkform()" name="myform">
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
					<div class="gouwuche fr"><a href="DingDan">我的订单</a></div>
					<div class="fr">
						<ul>
							<c:if test="${empty sessionScope.self.uname }">
							<li><a href="login.jsp">登录</a></li>
							<li>|</li>
							<li><a href="register.jsp">注册</a></li>
							<li>|</li>
						</c:if>
						<c:if test="${not empty sessionScope.self.uname }">
							<li>欢迎,${sessionScope.uname }&nbsp;&nbsp;</li>
							<li>|</li>
							<li><a href="Logout">退出</a></li>
							<li>|</li>
							<li><a href="main.jsp">首页</a></li>
							<li>|</li>
						</c:if>	
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
					<li>我的订单</li>
					<li>意外保</li>
					<li>团购订单</li>
					<li>评价晒单</li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li style="color:#ff6700;font-weight:bold;">修改个人信息</li>
					<li>消息通知</li>
					<li>优惠券</li>
				</ul>
			</div>
		</div>
		
		<div class="rtcont fr">
			<div class="grzlbt ml40">我的资料</div>
			
			<div class="subgrzl ml40"><span>用户名</span><span><input name="uname" value="${sessionScope.self.uname }" readonly="readonly"></span></div>
			
			<div class="subgrzl ml40"><span>手机号</span><span><input name="utel" value="${sessionScope.self.utel }"></span></div>
			
			<div class="subgrzl ml40"><span>密码</span><span><input type="password"  name="upassword" value="${sessionScope.self.upassword }"></span></div>
			<%-- <div class="subgrzl ml40"><span>电子邮箱</span><span>${sessionScope.self.uemail }</span></div> --%>
			<div class="subgrzl ml40"><span>电子邮箱</span><span><input name="uemail" value="${sessionScope.self.uemail }"></span></div>
		<%-- 	<div class="subgrzl ml40"><span>姓名</span><span>${sessionScope.self.utureName }</span></div> --%>
			<div class="subgrzl ml40"><span>姓名</span><span><input name="utureName" value="${sessionScope.self.utureName }"></span></div>
			<%-- <div class="subgrzl ml40"><span>收货地址</span><span>${sessionScope.self.uaddress }</span></div> --%>
			<div class="subgrzl ml40"><span>收货地址</span><span><input name="uaddress" value="${sessionScope.self.uaddress }"></span></div>
			 <div><input type="hidden" name="uid" value="${sessionScope.self.uid }"></div>
			 <div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;<input type="submit" value="保存并提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="返回个人中心"  href="self_info.jsp"></div> 
			
			
			 
		</div>
		
	
		
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
		<footer class="mt20 center">			
			<div class="mt20">手机商城|多宝聊|多看书城|路由器|视频电话|手机天猫店|手机淘宝直营店|手机网盟|中国移动|隐私政策|Select Region</div>
			<div>@234.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-****-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
		</form>
	</body>
</html>
